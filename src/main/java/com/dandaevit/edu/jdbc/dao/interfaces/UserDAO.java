package com.dandaevit.edu.jdbc.dao.interfaces;

import java.util.List;

import com.dandaevit.edu.jdbc.model.user.User;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.AllUsersSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.NoSuchUserException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserUpdatingException;

public interface UserDAO {
	User insertUser(User user) throws UserInsertionException;
	void deleteUser(int id) throws UserDeletingException;
	User updateUser(User user) throws UserUpdatingException;
	User getUsersByID(int id) throws NoSuchUserException;
	List<User> getAllUsers() throws AllUsersSelectionException;
}
