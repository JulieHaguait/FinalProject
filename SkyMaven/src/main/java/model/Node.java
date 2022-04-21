package model;

public class Node {

   private Node nodeParents;
   private Item item;
   
   
   // Constructeur
   public Node(Node nodeParents, Item item)
	{
		this.nodeParents = nodeParents;
		this.item = item;
	}
	
   
   // getters & setters
   
   public Node getNodeParents()
   {
      return nodeParents;
   }
   
   public void setNodeParents(Node nodeParents) 
   {
      		this.nodeParents = nodeParents;
   }
   
   public Item getItem()
   {
      return item;
   }
   
   public void setItem(Item item) 
   {
      		this.item = item;
   }
		

   // ToString
   
}
