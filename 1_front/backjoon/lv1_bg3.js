const fs = require('fs');
const input = fs.readFileSync("./input.txt").toString().trim().split(" ");

const num1 = parseInt(input[0]);
const num2 = parseInt(input[1]);

console.log(num1-num2);