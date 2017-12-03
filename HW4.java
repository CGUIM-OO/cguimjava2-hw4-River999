import java.util.ArrayList;/*資管二乙 B0544214 白柏妤*/
import java.util.HashMap;
//import java.util.Scanner;
public class HW4 {
	public static void main(String[] args) {
		int nDeck=4;
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that 
		Player player1=new Player("Player 1",100);//建立新的物件，名稱是player1(玩家1，籌碼100)
		Player player2=new Player("Player 2",300);//建立新的物件，名稱是player2(玩家2，籌碼300)
		player1.sayHello();
		player2.sayHello();
		int p1Bet=player1.makeBet();
		int p2Bet=player2.makeBet();
		ArrayList<Card> player1Card=new ArrayList<Card>();
		player1Card.add(deck.getOneCard(true));
		player1Card.add(deck.getOneCard(true));
		player1.setOneRoundCard(player1Card);
		
		ArrayList<Card> player2Card=new ArrayList<Card>();
		player2Card.add(deck.getOneCard(true));
		player2Card.add(deck.getOneCard(true));
		player2.setOneRoundCard(player2Card);
		boolean hit=false;
		do{
			hit=player1.hitMe(); //this
			if(hit){
				player1Card.add(deck.getOneCard(true));
				player1.setOneRoundCard(player1Card);
				System.out.print("Hit! ");
				System.out.println(player1.getName()+"'s Cards now:");
				for(Card c : player1Card){
					c.printCard();
				}
			}
			else{
				System.out.println(player1.getName()+", Pass hit!");
				System.out.println(player1.getName()+", Final Card:");
				for(Card c : player1Card){
					c.printCard();
				}
			}
		}while(hit);
		
		hit=false;
		do{
			hit=player2.hitMe(); //this
			if(hit){
				player2Card.add(deck.getOneCard(true));
				player2.setOneRoundCard(player2Card);
				System.out.print("Hit! ");
				System.out.println(player2.getName()+"'s Cards now:");
				for(Card c : player2Card){
					c.printCard();
				}
			}
			else{
				System.out.println(player2.getName()+", Pass hit!");
				System.out.println(player2.getName()+", Final Card:");
				for(Card c : player2Card){
					c.printCard();
				}
			}
		}while(hit);
		if(player1.getTotalValue()>21 && player2.getTotalValue()>21){//如果兩位玩家的牌都大於21(透過Player的getTotalValue來算)
			System.out.println("Need another game");
		}else if(player1.getTotalValue()<=21&&player2.getTotalValue()>21){//如果玩家1的牌小於等於，玩家2的牌大於21(透過Player的getTotalValue來算)
			System.out.println(player1.getName()+" wins the game");
			player1.increaseChips(p1Bet);//p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
			player2.increaseChips(-p2Bet);//-p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
		}else if(player1.getTotalValue()>21&&player2.getTotalValue()<=21){//如果玩家2的牌都小於等於，玩家1的牌大於21(透過Player的getTotalValue來算)
			System.out.println(player2.getName()+" wins the game");
			player1.increaseChips(-p1Bet);//-p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
			player2.increaseChips(p2Bet);//p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
		}else if(player1.getTotalValue()>player2.getTotalValue()&&player1.getTotalValue()<=21){//如果玩家1的牌大於玩家2的牌且玩家1的牌小於等於21(透過Player的getTotalValue來算)
			System.out.println(player1.getName()+" wins the game");
			player1.increaseChips(p1Bet);//p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
			player2.increaseChips(-p2Bet);//-p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
		}else if(player1.getTotalValue()<player2.getTotalValue()&&player2.getTotalValue()<=21){//如果玩家1的牌小於玩家2的牌，且玩家2的牌小於等於21(透過Player的getTotalValue來算)
			System.out.println(player2.getName()+" wins the game");
			player1.increaseChips(-p1Bet);//-p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
			player2.increaseChips(p2Bet);//p1Bet(輸入值)跑至Player的increaseChips(籌碼的變動)
		}else{
			System.out.println("Need another game");
		}
		System.out.println(player1.getName()+" has "+player1.getCurrentChips()+" chips");
		System.out.println(player2.getName()+" has "+player2.getCurrentChips()+" chips");

	}
	

}
