package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Salvar;
import model.Dados;
import model.Player;
import view.TelaGame;
import view.TelaMensagem;
import view.TelaMenu;

public class ControllerMenu {
	
	public ControllerMenu(TelaMenu tm) {
		
		Dados dados;
		dados = Salvar.ler();
		if (dados==null) {
			tm.getContinuarButton().setEnabled(false);
		}
		
		tm.getContinuarButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (dados.getPlayers().size()==1) {
					
					tm.setVisible(false);
					Player player = dados.getPlayers().get(0);
					
					TelaGame tg = new TelaGame(player);
					
					tg.setMapa1passou(dados.isMapa1passou());
					tg.setMapa2passou(dados.isMapa2passou());
					tg.setN_mapas_passados(dados.getN_mapaspassados());
					
					ControllerGame game = new ControllerGame(tg);
					
					ControllerPlayer cp1 = new ControllerPlayer(tg, player);
					tg.setCp1(cp1);
					
					new Thread(game).start();
					tm.dispose();
					
				}
				if (dados.getPlayers().size()==2) {
					
					tm.setVisible(false);
					Player player = dados.getPlayers().get(0);
					Player player2 = dados.getPlayers().get(1);
					
					TelaGame tg = new TelaGame(player, player2);
					
					tg.setMapa1passou(dados.isMapa1passou());
					tg.setMapa2passou(dados.isMapa2passou());
					tg.setN_mapas_passados(dados.getN_mapaspassados());
					
					ControllerGame game = new ControllerGame(tg);
					
					ControllerPlayer cp1 = new ControllerPlayer(tg, player, player2);
					tg.setCp1(cp1);
					
					new Thread(game).start();
					tm.dispose();
					
				}
				
			}
		});
		
		tm.getSingleplayerButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent
					arg0) {
				tm.setVisible(false);
				Player player = new Player(tm.getNomeField().getText());
				
				TelaGame tg = new TelaGame(player);
				ControllerGame game = new ControllerGame(tg);
				
				ControllerPlayer cp1 = new ControllerPlayer(tg, player);
				tg.setCp1(cp1);
				
				new Thread(game).start();
				tm.dispose();
			}
		});	
		
		tm.getMultiplayerButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				tm.setVisible(false);
				Player player = new Player(tm.getNomeField().getText());
				Player player2 = new Player(tm.getNome2Field().getText());
				
				TelaGame tg = new TelaGame(player, player2);
				ControllerGame game = new ControllerGame(tg);
				
				ControllerPlayer cp1 = new ControllerPlayer(tg, player, player2);
				tg.setCp1(cp1);
				
				new Thread(game).start();
				tm.dispose();
			}
		});	
		
		tm.getSairButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		tm.getInstrucoesButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String s = "Player 1                          Player 2" + "\n" +
						   " Andar - W A S D             Andar - Up Down Left Right" + "\n" +
						   " Atacar - Enter                Atacar - Numpad_1" + "\n" +
						   " Atirar - Espaço              Atirar - Numpad_2" + "\n" +
						   " Interagir - E                   Interagir - Numpad_3";
				TelaMensagem m = new TelaMensagem(s);
				ControllerTelaMensagem ctm = new ControllerTelaMensagem(m);
			}
		});
		
		tm.getCreditosButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String s = "Universidade: UFRPE-UAST" + "\n" +
						   "Orientando: Eduardo Gomes Ferreira Souza" + "\n" +
						   "Orientador: Prof. De. Richarlyson Alves D'Emery" + "\n" +
						   "Disciplina: MPOO" + "\n" +
						   "Semestre: 2019.1";
				TelaMensagem m = new TelaMensagem(s);
				ControllerTelaMensagem ctm = new ControllerTelaMensagem(m);
			
			}
		});
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	
}
