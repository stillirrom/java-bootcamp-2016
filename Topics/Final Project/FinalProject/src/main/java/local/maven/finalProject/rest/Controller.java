package local.maven.finalProject.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import local.maven.finalProject.services.ServicesImp;
import local.maven.finalProject.services.ServicesShoppingCart;

import local.maven.finalProject.model.Cart;
import local.maven.finalProject.model.Checkout;
import local.maven.finalProject.model.Error;
import local.maven.finalProject.model.Item;
import local.maven.finalProject.model.User;

@RestController
@RequestMapping("/store")
public class Controller {
	
	private ServicesShoppingCart services = new ServicesImp();
	
	@ApiOperation(value = "login", nickname = "login")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestParam(value = "nickname") String nickname,
			@RequestParam(value = "passwordUser") String passwordUser) {
		if (services.userLogin(nickname, passwordUser)) {
			int idUsr = services.getUserByNickname(nickname).getIdUser();
			return services.getCartByUserId(idUsr);
		} else {
			return new Error(1, "Login error. Please Verify UserName and/or Password.");
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object register(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "nickname") String nickname, @RequestParam(value = "passwordUser") String passwordUser) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setNickname(nickname);
		user.setPasswordUser(passwordUser);
		User user_ = services.userRegistration(user);
		if (user_ != null) {
			return user_;
		} else {
			return new Error(2, "The user couldn't be registered.");
		}
	}
	
	@RequestMapping(value = "/findby/category", method = RequestMethod.GET)
	public Object findByCategory(@RequestParam(value = "idCat") int idCat) {
		List<Item> list = services.findProductsByCategory(idCat);
		if (!list.isEmpty()) {
			return list;
		} else {
			return new Error(3, "There are no items asociated to this Category.");
		}
	}
	
	@RequestMapping(value = "/findby/name", method = RequestMethod.GET)
	public Object finByName(@RequestParam(value = "name") String name) {
		List<Item> list = services.findProductsByName(name);
		if (!list.isEmpty()) {
			return list;
		} else {
			return new Error(4, "There are no items with this Name.");
		}
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public Object cartByUserId(@RequestParam(value = "idUsr") int idUsr) {
		Cart cart = services.getCartByUserId(idUsr);
		if (cart != null) {
			return cart;
		} else {
			return new Error(5, "There are no carts for this Id.");
		}
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Object saveCart(@RequestParam(value = "idItem") int idItem, @RequestParam(value = "idCart") int idCart) {
		if (services.saveCart(idItem, idCart)) {
			int idAdded = services.getAddedByIdItemAndIdCart(idItem, idCart).getIdAdded();
			return services.getAddedByID(idAdded);
		} else {
			return new Error(6, "Error while saving Cart.");
		}
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public Object checkoutCart(@RequestParam(value = "idCart") int idCart) {
		Checkout checkout = services.buyProducts(idCart);
		if (checkout != null) {
			return checkout;
		} else {
			return new Error(7, "There are no items in this Cart.");
		}
	}	

	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public List<Item> viewItemsByCartId(@PathVariable int id) {
		return services.getItemByCartId(id);
	}
}
