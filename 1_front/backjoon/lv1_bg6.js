const fs = require('fs');
const input = fs.readFileSync("./input.txt").toString().trim().split(" ");

const num1 = Number(input[0]);
const num2 = Number(input[1]);

console.log(num1+num2);
console.log(num1-num2);
console.log(num1*num2);
console.log(Math.floor(num1/num2));
console.log(num1%num2);