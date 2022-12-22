import axios from "axios";
import React, { useState } from "react";
import { ITrainer } from "../../models/Trainer";
import { useAppDispatch } from "../../shared/Redux/hooks";
import "./Login.css";
import { setTrainer } from "./TrainerSlice";

function Login() {

    //Setting up Redux for this component
    const dispatch = useAppDispatch();
    //==============

    const [trainerId, setTrainerId] = useState(0);

    function updateTrainer(e:React.ChangeEvent<HTMLInputElement>) {

        setTrainerId(+e.target.value);

        console.log(trainerId);
        
    }

    function onSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();

        axios.get<ITrainer>(`http://smresteb-env.eba-u2i9uhvs.us-east-1.elasticbeanstalk.com/rest/getUserPokemon?id=${trainerId}`)
            .then(response => {
                console.log(response);

                //Logic to save information to our Redux Store specifically our trainer state
                dispatch(setTrainer(response.data));
            })
    }


    return <div>
        <form className="form-grid" onSubmit={onSubmit}>
            <label>Trainer Id</label>
            <input type="number" onChange={updateTrainer}/>
            <div></div>
            <input className="btn" type="submit" value="Login"/>
        </form>
    </div>;
}

export default Login;