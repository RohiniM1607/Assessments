import promptSync from "prompt-sync";
const prompt = promptSync();


function addition(num1: number, num2: number):number{
    return num1+num2;
}

function subtraction(num1: number, num2: number):number{
    return num1-num2;
}

function multiplication(num1: number, num2: number):number{
    return num1*num2;
}
function division(num1: number, num2: number): number{
    return num1/num2;
}

function mathematicalOperation(num1: number, num2: number){
    console.log("Addition: "+addition(num1, num2));
    if(num1>num2){
        console.log("Subtraction: "+subtraction(num1, num2));
    }
    else{
        console.log("Subtraction: "+subtraction(num2, num1));
    }
    console.log("Multiplication: "+multiplication(num1, num2));
    if(num2==0){
        console.log("Number can't divide by zero");
    }
    else{
        console.log("Division: "+division(num1, num2));
    }
}

let num1: number = Number(prompt("Enter First Number: "));
let num2: number = Number(prompt("Enter Second Number: "));

if((Number.isInteger(num1))||(Number.isInteger(num2)) ){
    mathematicalOperation(num1,num2);
}
else{
    console.log("Invalid Input");
}
