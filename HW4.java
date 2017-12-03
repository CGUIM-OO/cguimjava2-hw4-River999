import java.util.ArrayList;/*��ޤG�A B0544214 �լf��*/
import java.util.HashMap;
//import java.util.Scanner;
public class HW4 {
	public static void main(String[] args) {
		int nDeck=4;
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that 
		Player player1=new Player("Player 1",100);//�إ߷s������A�W�٬Oplayer1(���a1�A�w�X100)
		Player player2=new Player("Player 2",300);//�إ߷s������A�W�٬Oplayer2(���a2�A�w�X300)
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
		if(player1.getTotalValue()>21 && player2.getTotalValue()>21){//�p�G��쪱�a���P���j��21(�z�LPlayer��getTotalValue�Ӻ�)
			System.out.println("Need another game");
		}else if(player1.getTotalValue()<=21&&player2.getTotalValue()>21){//�p�G���a1���P�p�󵥩�A���a2���P�j��21(�z�LPlayer��getTotalValue�Ӻ�)
			System.out.println(player1.getName()+" wins the game");
			player1.increaseChips(p1Bet);//p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
			player2.increaseChips(-p2Bet);//-p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
		}else if(player1.getTotalValue()>21&&player2.getTotalValue()<=21){//�p�G���a2���P���p�󵥩�A���a1���P�j��21(�z�LPlayer��getTotalValue�Ӻ�)
			System.out.println(player2.getName()+" wins the game");
			player1.increaseChips(-p1Bet);//-p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
			player2.increaseChips(p2Bet);//p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
		}else if(player1.getTotalValue()>player2.getTotalValue()&&player1.getTotalValue()<=21){//�p�G���a1���P�j�󪱮a2���P�B���a1���P�p�󵥩�21(�z�LPlayer��getTotalValue�Ӻ�)
			System.out.println(player1.getName()+" wins the game");
			player1.increaseChips(p1Bet);//p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
			player2.increaseChips(-p2Bet);//-p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
		}else if(player1.getTotalValue()<player2.getTotalValue()&&player2.getTotalValue()<=21){//�p�G���a1���P�p�󪱮a2���P�A�B���a2���P�p�󵥩�21(�z�LPlayer��getTotalValue�Ӻ�)
			System.out.println(player2.getName()+" wins the game");
			player1.increaseChips(-p1Bet);//-p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
			player2.increaseChips(p2Bet);//p1Bet(��J��)�]��Player��increaseChips(�w�X���ܰ�)
		}else{
			System.out.println("Need another game");
		}
		System.out.println(player1.getName()+" has "+player1.getCurrentChips()+" chips");
		System.out.println(player2.getName()+" has "+player2.getCurrentChips()+" chips");

	}
	

}
