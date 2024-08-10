import { configureStore } from '@reduxjs/toolkit'
import userReducer from './reducers/userReducer'
import bookListReducer from './reducers/bookListReducer'

export const API_URL = 'http://localhost:8080';

export default configureStore({
    reducer: {
        user: userReducer,
        books: bookListReducer
    }
});