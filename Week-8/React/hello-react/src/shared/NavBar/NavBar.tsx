import { Link } from "react-router-dom";
import "./NavBar.css"

function NavBar() {
    
    return <div className="flex">
        {/* 
            We use Link component to direct users into whatever route you want
            Just make sure you spell it right
        */}
        <Link to="/">Home</Link>
        <Link to="/pokeList">Pokemon List</Link>
    </div>
}

export default NavBar;