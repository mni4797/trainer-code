import { Link } from "react-router-dom";
import { selectTrainer, setDefault } from "../../components/Login/TrainerSlice";
import { useAppDispatch, useAppSelector } from "../Redux/hooks";
import "./NavBar.css"

function NavBar() {
    //Redux related things
    const trainer = useAppSelector(selectTrainer);
    const dispatch = useAppDispatch();

    function logout(){
        dispatch(setDefault())
    }

    
    return <div className="flex">
        {/* 
            We use Link component to direct users into whatever route you want
            Just make sure you spell it right
        */}
        <Link to="/">Home</Link>
        <Link to="/pokeList">Pokemon List</Link>
        {
            trainer.name ? <Link to="/" onClick={logout}>Logout</Link> : <Link to="/login">Login</Link>
        }

        {
            trainer.name && <p>Welcome back {trainer.name}!</p>
        }
        
    </div>
}

export default NavBar;