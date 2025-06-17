const fs = require('fs');
const input = fs.readFileSync("./input.txt").toString().trim();

const num = Number(input);
console.log(num-543);