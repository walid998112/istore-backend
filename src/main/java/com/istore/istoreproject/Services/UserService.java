package com.istore.istoreproject.Services;



import java.util.List;

import com.istore.istoreproject.Requests.JwtToken;
import com.istore.istoreproject.Requests.LoginRequest;
import com.istore.istoreproject.Requests.RegisterRequest;
import com.istore.istoreproject.Requests.ResetPasswordRequest;
import com.istore.istoreproject.Requests.VerifTokenRequest;
import com.istore.istoreproject.models._User;

public interface UserService {

    void register(RegisterRequest registerRequest);

    JwtToken login(LoginRequest loginRequest);

    List<_User> getAll();

    _User getById(long id);

    _User getByUsername(String username);

    void disableEnableUser(long id);

    void updateUser(String username, _User user);

    void sendToken(String email);

    void verifToken(VerifTokenRequest request);

    void reset(ResetPasswordRequest resuest);

    void createAdmin(RegisterRequest registerRequest);
}
