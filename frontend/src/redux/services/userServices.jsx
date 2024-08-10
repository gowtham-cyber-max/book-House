import { API_URL } from "../store";
import axios from "axios";

class userService {
    signIn(user, password) {
        return axios.post(API_URL + "/api/user/login",
            {
                user,
                password
            }
        )
    }

    signUp(data) {
        return axios.post(API_URL + "/api/user/add", data)
    }

    wish(uid, bid) {
        return axios.get(API_URL + "/api/user/wish", { params: { uid, bid } });
    }

    getWishlistBooks(IDs) {
        return axios.post(API_URL + "/api/book/get-list", IDs);
    }
}

export default new userService();