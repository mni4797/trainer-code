import { useState } from "react";


function Counter() {
    //the paremeter in useState will determine the default value of this variable
    //count variable is a state
    const [count, setCount] = useState(0);

    const [show, setShow] = useState(false);


    function AddCounter() {

        //Make sure you use the method that was given to you to actually re-render the page
        setCount(count + 1);
        // count = count + 1 //will not work and interacting with the variable directly will not re-render page

        console.log(count);
    }

    function showComponent() {
        setShow(!show);
    }

    //Conditional rendering in which we can dynamically show a different "view" of the component based on some condition
    //You just have multiple return statement
    // if (!show) {
    //     return <div>
    //         <button onClick={showComponent}>Click here to show Pokemon Counter</button>
    //     </div>

    // }else {

    //     return <div>
    //     <p>Current counter: {count}</p>
    //     <button onClick={AddCounter}>+</button>
    // </div>
    // }

    return <div>
        <button onClick={showComponent}>Click me to show Counter</button>

        {/* Inline if statement */}
        {
            !show && <div>
                <p>Current counter: {count}</p>
                <button onClick={AddCounter}>+</button>
            </div>
        }
     </div>
    
}

export default Counter;