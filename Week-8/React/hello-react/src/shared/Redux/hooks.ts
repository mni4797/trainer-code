/**
 * Unfortunately, Redux doesn't fully support TS all the way
 * So, we have to create our own hooks and add strict typing to it
 */

import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "./store";

export const useAppDispatch: () => AppDispatch = useDispatch;
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector;