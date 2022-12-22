import React from "react";

/**
 * Class components are just component made by using a class
 * 
 * No used as much mostly because React shifted philosophy into thinking that
 * React components must act like pure functions
 */

class ClassComponent extends React.Component {

    render() {
        return <div>
            This is a class component!
        </div>
    }
}

export default ClassComponent;