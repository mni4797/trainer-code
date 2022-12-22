import { configureStore } from "@reduxjs/toolkit";
import TrainerSlice from "../../components/Login/TrainerSlice";

export const store = configureStore({
    reducer: {
        trainer: TrainerSlice
    }
})

/**
 * Unfortunately, Redux doesn't have strict typing in their modules that you installed
 * So, we have to do some extra configuration to enforce TS behavior (strict typing)
 */
export type AppDispatch = typeof store.dispatch
export type RootState = ReturnType<typeof store.getState>