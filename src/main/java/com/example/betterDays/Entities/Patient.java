package com.example.betterDays.Entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
public class Patient implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String nickName;
    @Column(unique = true)
    private String email;
    private String password;
    private int age;
    private String authority;
    @OneToMany(mappedBy="doctorWatingEntity")
    private List<DoctorWaiting> DoctorWaitingList  ;
    @ManyToOne
    private DoctorEntity doctorEntity;
    @OneToOne
    private Event booking;
    private ArrayList<Story> stories;
    private String tester;

    public Patient(){}
    public Patient(String firstName, String lastName, String userName, String nickName, String email, String password, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.authority="role_patient";
    }
    public Patient(String firstName, String lastName, String userName, String nickName, String email, String password, int age,String tester) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.authority="role_patient";
        this.tester=tester;
        this.id=id;
    }

    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(authority);
        ArrayList<SimpleGrantedAuthority> grantedAuthorities=new ArrayList<SimpleGrantedAuthority>();
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public DoctorEntity getDoctorEntity() {
        return doctorEntity;
    }
    public void setDoctorEntity(DoctorEntity doctorEntity) {
        this.doctorEntity = doctorEntity;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Event getBooking() {
        return booking;
    }
    public void setBooking(Event booking) {
        this.booking = booking;
    }

    public ArrayList<Story> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }
    public void addStory(Story story){
            this.stories.add(story);
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }



    public void addWattingDoctor(DoctorWaiting doctorwaiting){
        if (this.DoctorWaitingList.contains(doctorwaiting))
            System.out.println("already a patient");
        else
            this.DoctorWaitingList.add(doctorwaiting);
    }

    public List<DoctorWaiting> getDoctorWaitingList() {
        return DoctorWaitingList;
    }

    public void setDoctorWaitingList(List<DoctorWaiting> doctorWaitingList) {
        DoctorWaitingList = doctorWaitingList;
    }
}
