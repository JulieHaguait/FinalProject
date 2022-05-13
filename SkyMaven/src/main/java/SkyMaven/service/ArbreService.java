package SkyMaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.Arbre;
import SkyMaven.entity.Node;
import SkyMaven.repository.ArbreRepository;
import SkyMaven.service.NodeService;


@Service
public class ArbreService {
@Autowired 
private ArbreRepository arbreRepository;
@Autowired
NodeService ns;

	/*
	public List<Arbre> getAll() {
		return arbreRepository.findAll();
	}
*/
	public Arbre getById(Long id) {
		return arbreRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public void create(Arbre arbre) {
		arbreRepository.save(arbre);
	}

	public Arbre update(Arbre arbre) {
		return arbreRepository.save(arbre);
	}
	
	public void deleteById(Long id) {
		Arbre arbre = new Arbre();
		arbre.setId(id);
		List<Node> ns = ns.getAllByArbre(arbre.getId()); 
		for(Node n : ns) 
		{
			ns.delete(n);
		}
		arbreRepository.delete(arbre);
	}
}