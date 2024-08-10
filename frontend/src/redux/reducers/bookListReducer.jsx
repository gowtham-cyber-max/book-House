const initialState = {
    books: [],
    genres: [],
    currentPage: 0,
    limitReached: false,
    loading: false,
}

export default function bookListReducer(state = initialState, action) {
    switch (action.type) {
        case "LOADING":
            return {
                ...state,
                books: [],
                loading: true,
            }
        case 'ADD_BOOKS':
            return {
                ...state,
                books: [...state.books, ...action.payload],
                currentPage: state.currentPage + 1,
            }
        case 'NEXT_BOOKS':
            return {
                ...state,
                loading: true,
            }
        case "ALL_BOOKS":
            return {
                ...state,
                books: action.payload,
                currentPage: 0,
                limitReached: true,
                loading: false,
            }
        case "EMPTY_LIST":
            return {
                ...state,
                books: [],
                currentPage: 0,
                limitReached: false,
                loading: false,
            }
        case 'LIMIT_REACHED':
            return {
                ...state,
                limitReached: true,
            }
        case 'SEARCHED_BOOKS':
            return {
                ...state,
                books: action.payload,
                currentPage: 0,
                limitReached: false,
                loading: true,
            }
        case 'CANCEL_SEARCH':
            return {
                ...state,
                currentPage: 0,
                loading: false,
            }
        case 'GENRES':
            return {
                ...state,
                genres: action.payload,
            }
        default:
            return state
    }
}