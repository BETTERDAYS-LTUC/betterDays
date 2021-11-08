/*------------------*/
//Store answers and then add them up

// create an empty object to store answers
var answers = [];

// get each question div element

var question_one = document.getElementById('question-1');
var question_two = document.getElementById('question-2');
var question_three = document.getElementById('question-3');
var question_four = document.getElementById('question-4');
var question_five = document.getElementById('question-5');
var question_six = document.getElementById('question-6');
var question_seven = document.getElementById('question-7');
var question_eight = document.getElementById('question-8');
var question_nine = document.getElementById('question-9');
var question_ten = document.getElementById('question-10');
var question_eleven = document.getElementById('question-11');
var question_twelve = document.getElementById('question-12');
var question_thirteen = document.getElementById('question-13');
var question_fourteen = document.getElementById('question-14');
var question_fifteen = document.getElementById('question-15');


// create event listeners so that when a radio button is clicked the 'value' is added to answers object as a value. All answers from the same question are stored in the same object property so choices overright each other!

// create a function that adds HTML input values to new properties in answers object. 'parseInt' converts string to number.


function storeAnswer(question_number, event) {
  if (event.target.type === 'radio') {
    console.log(event.target.value);
    console.log(answers);
    answers.push(event.target.value);
  }
}

//add event listener to each question div. Click event calls storeAnswer function with corresponding question number passed as an argument so that correct object property is created

question_one.addEventListener('click',
 function(event) {
  storeAnswer(1, event);
});

question_two.addEventListener('click',
function(event) {
  storeAnswer(2, event);
});

question_three.addEventListener('click', function(event) {
  storeAnswer(3, event);
});

question_four.addEventListener('click', function(event) {
  storeAnswer(4, event);
});

question_five.addEventListener('click', function(event) {
  storeAnswer(5, event);
});

question_six.addEventListener('click', function(event) {
  storeAnswer(6, event);
});

question_seven.addEventListener('click', function(event) {
  storeAnswer(7, event);
});

question_eight.addEventListener('click', function(event) {
  storeAnswer(8, event);
});

question_nine.addEventListener('click', function(event) {
  storeAnswer(9, event);
});

question_ten.addEventListener('click', function(event) {
  storeAnswer(10, event);
});

question_eleven.addEventListener('click', function(event) {
  storeAnswer(11, event);
});

question_twelve.addEventListener('click', function(event) {
  storeAnswer(12, event);
});

question_thirteen.addEventListener('click', function(event) {
  storeAnswer(13, event);
});

question_fourteen.addEventListener('click', function(event) {
  storeAnswer(14, event);
});

question_fifteen.addEventListener('click', function(event) {
  storeAnswer(15, event);
});


// create a function to add up all answers. I hate this because I've had to hard code the answer object's properties. Need to make BETTER

function totalScore() {
  var total_score = 0;
  for(let i = 0 ; i<= answers.length ; i++){
    if(answers[i] == "yes")
        total_score++;
  }

  return total_score;

}

// create a function that returns information about score depending on what the score is

function getInfoBasedOnScore() {
  if(totalScore() < 3 ) {
      var score_info = "you are good.";
  } else if(totalScore() == 3 ) {
      var score_info = "you have a drinking or drug problem.";
  } else if(totalScore() >= 4 && totalScore() < 7) {
      var score_info = "you are in an early stage of alcoholism or drug addiction.";
  } else if(totalScore() >= 7 && totalScore() < 10){
      var score_info = "you are in the second stage of alcoholism or drug addiction.";
  } else{
      var score_info = "you are in the end stage of alcoholism or drug addiction.";
  };

  return score_info;

}


/*-------------------------------------*/
/*Show and Hide questions on submit*/

// get each submit button element
var submit1 = document.getElementById('submit1');
var submit2 = document.getElementById('submit2');
var submit3 = document.getElementById('submit3');
var submit4 = document.getElementById('submit4');
var submit5 = document.getElementById('submit5');
var submit6 = document.getElementById('submit6');
var submit7 = document.getElementById('submit7');
var submit8 = document.getElementById('submit8');
var submit9 = document.getElementById('submit9');
var submit10 = document.getElementById('submit10');
var submit11 = document.getElementById('submit11');
var submit12 = document.getElementById('submit12');
var submit13 = document.getElementById('submit13');
var submit14 = document.getElementById('submit14');
var submit15 = document.getElementById('submit15');

// declare a function that toggles display style of question divs
// the function takes an argument which should be THE NEXT QUESTION number
function nextQuestion(question_number) {

  //get the last question number (the argument passed minus 1!)
  var current_question_number = question_number - 1;

  //turn both question number vars into strings
  var question_number = question_number.toString();
  var current_question_number = current_question_number.toString();

  //get the next question div element (concatenate next q number onto to 'question-')
  var el = document.getElementById('question-'+question_number);

  //get the current question div element
  var el2 = document.getElementById('question-'+current_question_number);

  //display next question
  el.style.display = "block";

  //hide current question
  el2.style.display = "none";
}

//add event listeners to each submit button element and call nextQuestion function on click. Also calling function to grow progress bar.
submit1.addEventListener('click', function() {

  nextQuestion(2);
  growProgressBar('13.2%');
});

submit2.addEventListener('click', function() {
  nextQuestion(3);
  growProgressBar('19.8%');
});

submit3.addEventListener('click', function() {
  nextQuestion(4);
  growProgressBar('26.4%');
});

submit4.addEventListener('click', function() {
  nextQuestion(5);
  growProgressBar('33%');
});

submit5.addEventListener('click', function() {
  nextQuestion(6);
  growProgressBar('39.6%');
});

submit6.addEventListener('click', function() {
  nextQuestion(7);
  growProgressBar('46.2%');
});

submit7.addEventListener('click', function() {
  nextQuestion(8);
  growProgressBar('52.8%');
});

submit8.addEventListener('click', function() {
  nextQuestion(9);
  growProgressBar('59.4%');
});

submit9.addEventListener('click', function() {
  nextQuestion(10);
  growProgressBar('66%');
});

submit10.addEventListener('click', function() {
  nextQuestion(11);
  growProgressBar('72.6%');
});

submit11.addEventListener('click', function() {
  nextQuestion(12);
  growProgressBar('79.2%');
});

submit12.addEventListener('click', function() {
  nextQuestion(13);
  growProgressBar('85.8%');
});

submit13.addEventListener('click', function() {
  nextQuestion(14);
  growProgressBar('92.4%');
});

submit14.addEventListener('click', function() {
  nextQuestion(15);
  growProgressBar('100%');
});

submit15.addEventListener('click', function() {
  nextQuestion(16);
});


/*-------------------------------------*/
/*Display score and badge*/

submit15.addEventListener('click', function() {

  //print answers to questions by adding respective object properties to innerHTML of correct p elements on thank you page!
  document.getElementById("printscoreinfo").innerHTML = getInfoBasedOnScore();
  document.getElementById("submit").value= totalScore() ;


});

/*End of functionality -------------------------------------------------------------
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
--------------------------------------------------------------------------*/


/*Pretty things -----------------------------------------------------------------*/

function growProgressBar(percentage_width) {
  var bar = document.getElementById("progress_bar");
  bar.style.width = percentage_width;
}

/*----TO DO----*/
//display a report at the end showing all answers and info for each one

//Sometimes Always Never