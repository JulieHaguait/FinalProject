package SkyMaven.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
NodeService nds;

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
	
	public void delete(Arbre arbre) {
		List<Node> ns = nds.getAllByArbre(arbre.getId()); 
        for(Node n : ns) 
        {
            nds.delete(n);
        }
        arbreRepository.delete(arbre);
	}
	
	public void deleteById(Long id) {
        
	}
}