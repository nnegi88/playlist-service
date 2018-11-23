package com.cvt.playlistservice.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Playlist not found")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId){
        super("User with userId "+userId+" is not found");
    }
}
