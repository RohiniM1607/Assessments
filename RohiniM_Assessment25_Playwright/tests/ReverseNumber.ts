import promptSync from "prompt-sync";
const prompt = promptSync();

function reverseNumber(num: number): number {
    let res = 0;
    while (num > 0) {
        let rem = num % 10;
        res = (res * 10) + rem;
        num = Math.floor(num / 10);
    }
    return res;
}

let num: number = Number(prompt("Enter the number: "));
if (num >= 10000 && num <= 99999) {
    let res = reverseNumber(num);
    console.log("Reversed Number:", res);
} 
else {
    console.log("Please enter a 5-digit number.");
}