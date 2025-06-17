const fs = require('fs');
const input = fs.readFileSync("./input.txt").toString().trim().split(" ");

const a = Number(input[0]);
const b = Number(input[1]);
const c = Number(input[2]);

console.log((a+b)%c);
console.log(((a%c)+(b%c))%c);
console.log((a*b)%c);
console.log(((a%c)*(b%c))%c);