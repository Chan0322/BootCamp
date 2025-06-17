const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().split('\n');

let num1 = input[0].split(''); // 각 자릿수별로 쪼개기
let num2 = input[1].split('');

let n1 = Number(input[0]) * Number(num[2]); // 곱셈
let n2 = Number(input[0]) * Number(num[1]);
let n3 = Number(input[0]) * Number(num[0]);

console.log(n1);
console.log(n2);
console.log(n2);
console.log((n3*100) + (n2 * 10) + n1);