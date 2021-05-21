package hust.soict.dsai.aims.screen.store;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.cart.CartScreen;
import hust.soict.dsai.aims.screen.updatestore.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.updatestore.AddCompactDiscToStoreScreen;
import hust.soict.dsai.aims.screen.updatestore.AddDigitalVideoDiscToStoreScreen;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Container cp;
	private Store store;
	private Cart cart;
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new AddBookListener());
		smUpdateStore.add(addBook);
		
		JMenuItem addCd = new JMenuItem("Add CD");
		addCd.addActionListener(new AddCdListener());
		smUpdateStore.add(addCd);
		
		JMenuItem addDvd = new JMenuItem("Add DVD");
		addDvd.addActionListener(new AddDvdListener());
		smUpdateStore.add(addDvd);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		
		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(new ViewCartListener());
		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		cart.addActionListener(new ViewCartListener());
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
		
	}
	
	
	private class AddCdListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddCompactDiscToStoreScreen(store, cart);
		}
		
	}
	
	private class AddBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddBookToStoreScreen(store, cart);
		}
		
	}
	
	private class AddDvdListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddDigitalVideoDiscToStoreScreen(store, cart);
		}
		
	}
	
	
	private class ViewCartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new CartScreen(cart, store);
		}
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel {
		private Media media;
		public MediaStore(Media media) {
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
			
			JLabel cost = new JLabel("" + media.getCost()+" $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JButton addToCartButton = new JButton("Add to cart");
			addToCartButton.addActionListener(new AddToCartListener());
			container.add(addToCartButton);
			if (media instanceof Playable) {
				JButton playButton = new JButton("Play");
				playButton.addActionListener(new PlayButtonListener());
				container.add(playButton);
			}
			
			JButton removeButton = new JButton("Remove from store");
			removeButton.addActionListener(new RemoveMediaFromStoreListener());
			container.add(removeButton);
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		
		private class RemoveMediaFromStoreListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				try {
					store.removeMedia(media);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cp.removeAll();
				cp = getContentPane();
				cp.setLayout(new BorderLayout());
				
				cp.add(createNorth(), BorderLayout.NORTH);
				cp.add(createCenter(), BorderLayout.CENTER);
				
				setVisible(true);
				setTitle("Store");
				setSize(1024, 768);
			}
			
		}
		
		
		private class PlayButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (media instanceof DigitalVideoDisc) {
					try {
						((DigitalVideoDisc) media).play();
					} catch (PlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (media instanceof CompactDisc) {
					try {
						((CompactDisc) media).play();
					} catch (PlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
		private class AddToCartListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f, "Media successfully added to cart", "Message", JOptionPane.INFORMATION_MESSAGE);
				try {
					cart.addMedia(media);
				} catch (LimitExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}

	}
	
	public StoreScreen(Store store, Cart cart) {
		// TODO Auto-generated constructor stub
		this.store = store;
		this.cart = cart;
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Store store = new Store();
		ArrayList<Track> tracks = new ArrayList<Track>();
		Track track1 = new Track("Track1", 50);
		Track track2 = new Track("Track2", 50);
		tracks.add(track1);
		tracks.add(track2);
		CompactDisc cd = null;
		try {
			cd = new CompactDisc("Some CD name idk", "Pop", 50f, "20/01/2001", 100, "Someone chad", "Someone cheems",
					tracks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DigitalVideoDisc dvd1 = null;
		try {
			dvd1 = new DigitalVideoDisc("The Lion King",
					"Animation", 19.8f, "1/1/2021", "Roger Allers", 87);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		DigitalVideoDisc dvd2 = null;
		try {
			dvd2 = new DigitalVideoDisc("Star Wars",
					"Science Fiction", 24.95f, "1/1/2021", "George Lucas", 87);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		DigitalVideoDisc dvd3 = null;
		try {
			dvd3 = new DigitalVideoDisc("Aladin",
					"Animation", 18.99f, "1/1/2021/", "Someone", 100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		
		List<String> authors = new ArrayList<String>();
		authors.add("Dr.Nguyen Thieu Huy");
		Book b = null;
		try {
			b = new Book("Lecture on Algebra", "Textbook", 10.0f, "1/1/2021", authors);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		
		try {
			store.addMedia(dvd1);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		try {
			store.addMedia(dvd2);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		try {
			store.addMedia(dvd3);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		try {
			store.addMedia(b);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		try {
			store.addMedia(cd);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		new StoreScreen(store, cart);
	}

}
