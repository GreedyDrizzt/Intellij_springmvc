package com.yuhong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.yuhong.model.Toy;
import com.yuhong.service.ToyService;

@Controller
public class ToyController {

    private static final Logger logger = Logger
		.getLogger(ToyController.class);

    public ToyController() {
		System.out.println("ToyController()");
	}

    @Autowired
    private ToyService toyService;


    @RequestMapping(value = {"", "/", "home"})
    public ModelAndView listToy(ModelAndView model) throws IOException {
    	List<Toy> listToy = toyService.getAllToys();
    	model.addObject("listToy", listToy);
    	model.setViewName("home");
    	return model;
    }

    @RequestMapping(value = "/newToy", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
    	Toy movi = new Toy();
    	model.addObject("Toy", movi);
    	model.setViewName("Toy-form");
    	return model;
    }

    @RequestMapping(value = "/saveToy", method = RequestMethod.POST)
    public ModelAndView saveToy(@ModelAttribute Toy movi) {
        if (movi.getId() == 0) { // if Toy id is 0 then creating the
            // Toy other updating the Toy
            toyService.addToy(movi);
    	} else {
            toyService.updateToy(movi);
    	}
    	return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteToy", method = RequestMethod.GET)
    public ModelAndView deleteToy(HttpServletRequest request) {
        int ToyId = Integer.parseInt(request.getParameter("id"));
        toyService.deleteToy(ToyId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editToy", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int ToyId = Integer.parseInt(request.getParameter("id"));
        Toy movi = toyService.getToy(ToyId);
        ModelAndView model = new ModelAndView("Toy-form");
        model.addObject("Toy", movi);

    	return model;
    }

}