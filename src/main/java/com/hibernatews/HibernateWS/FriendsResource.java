package com.hibernatews.HibernateWS;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hibernatews.dao.DAO;
import com.hibernatews.entities.Friends;

@Path("/friends")
public class FriendsResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Friends> getFriends() {
		return new DAO().getAllFriends();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Friends addFriend(Friends newFriend) {
		new DAO().addFriend(newFriend);
		return newFriend;
	}
	
	@GET
	@Path("/{friendID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Friends getSingleFriend(@PathParam("friendID") int id) {
		return  new DAO().getSingleFriend(id);
	}
	
	@PUT
	@Path("/{friendID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Friends updateFriend(@PathParam("friendID") int id, Friends updatedFriend) {
		updatedFriend.setId(id);
		new DAO().updateFriend(updatedFriend);
		return updatedFriend;
	}
	
	@DELETE
	@Path("/{friendID}")
	public void deleteFriend(@PathParam("friendID") int id) {
		new DAO().deleteFriend(id);
	}
	
}






