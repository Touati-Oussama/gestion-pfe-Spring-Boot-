package gestion.pfe.RestControllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import gestion.pfe.entities.Direction;
import gestion.pfe.services.DirectionService;

@RestController
@RequestMapping("/api/Direction")
@CrossOrigin
public class DirectionRESTController {
	
	@Autowired
	DirectionService directionService;
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<Direction> getAllDirections(){
		
		return directionService.getAllDirections();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Direction  getDirectionById(@PathVariable("id") int id)
	{
		return directionService.getDirection(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public 	Direction createDirection(@RequestBody Direction Direction) {;
		return directionService.saveDirection(Direction);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Direction updateDirection(@RequestBody Direction Direction) {
		
		return directionService.updateDirection(Direction);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteDirection(@PathVariable("id") int id) {
		directionService.deleteDirectionById(id);
	}
	

	


}