var global = 'global scope';

function someFunc() {
    console.log(global);
    let block = 'block scope';
    console.log(block);
    if (true) {
        // var sets variables to function scope
        var block2 = 'another block scope';
        let block3 = 'yet another block scope';

    }
    console.log(block2);
    // this throws an error
    //console.log(block3);
}
someFunc();

function closure() {
    let ctr = 0;
    return function counter() {
        // lexical scope - having access to parent functions variables
        return ctr++;
    }
};

let counter = closure();
console.log('counter: ' + counter()); // 0
console.log('counter: ' + counter()); //1

let counter2 = closure();
console.log('counter2: ' + counter2()); //0
console.log('counter2: ' + counter2()); //1
console.log('counter2: ' + counter2()); //2
console.log('counter2: ' + counter2());//3
console.log('counter: ' + counter())