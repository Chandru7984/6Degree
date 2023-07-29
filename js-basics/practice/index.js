
let name = 'Chandru';
console.log(name);

let firstName = 'Chandru', lastName = 'AS';
console.log(firstName, lastName);

let firstName1;
let lastName1;

//Cannot be a reserved word
//Should be meaningful
//Cannot start with a number
//Cannot contain a space or hyphen
//Are case-sensitive

const interestRate = 0.5;
//interestRate = 2;
console.log(interestRate);

//If we won't re-assign the value, then go for const...
//let and var re-assigns the value...

//Two types of data types --> Primitive types and Reference types
//Primitive --> String, Number, Boolean, Undefined and null

let name1 = 'Praj';//string literal
let age = 30;//Number literal
let isDeleted = 'fasle';//Boolean literal
let firstName2 = undefined;
let lastName2 = null;

//Mainly JavaScript is a Dynamic language

//Object --> having key, value pairs

let employee = {
    name: 'Chandru',
    age: 25
};

//Dot Notation
employee.name = 'Praj';

//Bracket Notation
let selection = 'name';
employee[selection] = 'Chandan';

console.log(employee);

//Arrays

let color = ['purple', 'Green', 'Black'];
color[3] = 'blue';
console.log(color.length);

//Functions

//Performing a task
function speak(name, lastName) {
    console.log('Hello World' + name + ' ' + lastName)
}

speak('Chandru', 'AS');

//Calculating a value

function square(number) {
  return number * number;
}

console.log(square(3));
