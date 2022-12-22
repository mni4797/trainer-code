/**
 * Slice in Redux is somewhat the same as getting a slice of a pizza
 * 
 * Slice will take a portion of your Redux Store and in this particular portion will have the State as well as the Reducers
 */

import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { ITrainer } from "../../models/Trainer";
import { RootState } from "../../shared/Redux/store";

//Setting up the initial state of this slice and giving it a type
const initialState: ITrainer = {
    id: 0,
    listOfPokemon: [],
    name: "",
    totalBadge: 0
}

const trainerSlice = createSlice({
    name: "trainer",
    initialState,

    /**
     * Since the store is immutable, we need to dictate to Redux how can we change our value
     * 
     * 
     */
    reducers: {
        //state parameter will hold the current information from the store
        setTrainer: (state, action: PayloadAction<ITrainer>) => {
            // Deep within Redux documentation. They have have stated that reducers must change its reference value to "detect" any change
            // state = action.payload; //WILL NOT WORK

            state.id = action.payload.id;
            state.listOfPokemon = action.payload.listOfPokemon;
            state.name = action.payload.name;
            state.totalBadge = action.payload.totalBadge;
        },
        //You can setup more than one reducer if you want to change the behavior of how you want to manipulate the state
        //TLDR: this is for logging out
        setDefault: (state) => {
            state.listOfPokemon = [];
            state.id = 0;
            state.name = "";
            state.totalBadge = 0;
        }
    }
})

//We want to export everything so every component will have access to our reducers
export const {setTrainer, setDefault} = trainerSlice.actions;

//Letting our store have access to this slicer's reducers
export default trainerSlice.reducer;

//Letting all our component have the capability to access this Slicer's state
//TLDR: this gives our component access to the actual trainer data in our store
export const selectTrainer = (state:RootState) => state.trainer;

