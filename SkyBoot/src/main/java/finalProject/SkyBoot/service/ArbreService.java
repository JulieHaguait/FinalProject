package finalProject.SkyBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.Arbre;
import finalProject.SkyBoot.entity.ArbreInProgress;
import finalProject.SkyBoot.repository.ArbreRepository;

@Service
public class ArbreService {
	
	@Autowired 
	private ArbreRepository arbreRepository;
	@Autowired
	NodeService nds;

	
	public List<Arbre> getAll() {
		List<Arbre> larbre = arbreRepository.findAllWithNodes();
		
		/*List<Arbre> result = new ArrayList<Arbre>();
		
		for(Arbre a: larbre) {
			System.out.println(a.getId());
			Arbre resultArbre = getByIdWithNodes(a.getId());
			System.out.println(resultArbre.getNodes());
			result.add(resultArbre);
		}
		
		System.out.println(result.get(0) + "-" + result.get(1))
		;*/
		
		return larbre;
	}
	
	public Arbre getByNom(String nom) {
		return arbreRepository.findByNom(nom).orElseThrow(RuntimeException::new);
	}

	public Arbre getById(Long id) {
		return arbreRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public Arbre getByIdWithNodes(Long id) {
		return arbreRepository.findByIdWithNodes(id).orElseThrow(RuntimeException::new);
	}

	public void create(Arbre arbre) {
		arbreRepository.save(arbre);
	}

	public Arbre update(Arbre arbre) {
		return arbreRepository.save(arbre);
	}

	public void delete(Arbre arbre) {
		List<Node> ns = nds.getAllByArbre(arbre);
		for (Node n : ns) {
			nds.delete(n);
		}
		arbreRepository.delete(arbre);
	}

	public void deleteById(Long id) {

	}

}