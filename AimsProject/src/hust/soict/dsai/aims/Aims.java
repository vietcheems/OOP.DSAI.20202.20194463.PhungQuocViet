package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = null;
		try {
			dvd1 = new DigitalVideoDisc("The Lion King",
					"Animation", 19.95f, "1/1/2021", "Roger Allers", -1);
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

//		List<String> authors = new ArrayList<String>();
//		authors.add("Dr.Nguyen Thieu Huy");
//		Book b = new Book("Lecture on Algebra", "Textbook", 10.0f, "1/1/2021", authors);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		for (DigitalVideoDisc dvd : dvdList) {
			try {
				store.addMedia(dvd);
			} catch (LimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
//		store.addMedia(b);
		
		
		Scanner sc = new Scanner(System.in);
		int input1;
		boolean notDone1 = true;
		while (notDone1) {
			System.out.println("\n\n\n\n\n");
			showMenu();
			input1 = Integer.valueOf(sc.nextLine());
			switch (input1) {
			//view store
			case 1:
				boolean notDone2 = true;
				int input2;
				while (notDone2) {
					System.out.println("\n\n\n\n\n");
					System.out.println("Items available in store:");
					store.printStore();
					storeMenu();
					input2 = Integer.valueOf(sc.nextLine());
					switch (input2) {
					//see a media's details
					case 1:
						System.out.println("Title of the media: ");
						String title;
						title = sc.nextLine();
						if (store.searchByTitle(title)) {
							Media m = store.getMediaByTitle(title);
							//play?
							System.out.println("Play this media?(y/n)");
							String play = sc.nextLine();
							if (play.equals("y")) {
								if (m.getClass().equals(DigitalVideoDisc.class)) {
									DigitalVideoDisc item = (DigitalVideoDisc) m;
									try {
										item.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										JFrame f = new JFrame();
										JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
									}
								}
								else if (m.getClass().equals(CompactDisc.class)) {
									CompactDisc item = (CompactDisc) m;
									try {
										item.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										JFrame f = new JFrame();
										JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
									}
								}
							}
							else if (play.equals("n")) {
								System.out.println("Decided not to play this media");
							}
							else {
								System.out.println("Invalid answer");
							}


							//add to cart?
							System.out.println("Add this media to cart?(y/n)");
							String addToCart = sc.nextLine();
							if (addToCart.equals("y")) {
								try {
									cart.addMedia(m);
								} catch (LimitExceededException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									JFrame f = new JFrame();
									JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
								}
								cart.printList();
							}
							else if (addToCart.equals("n")) {
								System.out.println("Decided not to add this media to cart");
							}
							else {
								System.out.println("Invalid answer");
							}				
						}
						break;
					//add a media to cart
					case 2:
						System.out.println("Title of the media: ");
						String title1;
						title1 = sc.nextLine();
						if (store.searchByTitle(title1)) {
							Media m = store.getMediaByTitle(title1);
							try {
								cart.addMedia(m);
							} catch (LimitExceededException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
							}
							cart.printList();
						}
						break;
					//play a media
					case 3:
						System.out.println("Title of the media: ");
						String title2;
						title2 = sc.nextLine();
						if (store.searchByTitle(title2)) {
							Media m = store.getMediaByTitle(title2);
							if (m.getClass().equals(DigitalVideoDisc.class)) {
								DigitalVideoDisc item = (DigitalVideoDisc) m;
								try {
									item.play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									JFrame f = new JFrame();
									JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
								}
							}
							else if (m.getClass().equals(CompactDisc.class)) {
								CompactDisc item = (CompactDisc) m;
								try {
									item.play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									JFrame f = new JFrame();
									JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
								}
							}
							else System.out.println("Media not playable");
						}
						break;
					//see current cart
					case 4:
						cart.printList();
						break;
					//exit
					case 0:
						notDone2 = false;
						System.out.println("Exiting");
						break;
					//default
					default:
						System.out.println("Not an available option. Please choose again\n");
					}
				}
				break;
			//update store
			case 2:
				boolean notDone3 = true;
				int input3;
				while (notDone1) {
					System.out.println("\n\n\n\n\n");
					updateStoreMenu();
					input3 = Integer.valueOf(sc.nextLine());
					switch (input3) {
					case 1:
						System.out.println("Options: ");
						System.out.println("_________________________________");
						System.out.println("1. DVD");
						System.out.println("2. Book");
						System.out.println("3. CD");
						System.out.println("0. Exit");
						System.out.println("_________________________________");
						System.out.println("Please choose a number: 0-1-2-3");
						int input4 = Integer.valueOf(sc.nextLine());
						switch (input4) {
						case 1:
							String titledvd;
							String category;
							float cost;
							String dateAdded;
							String director;
							int length;
							System.out.println("Title:");
							titledvd = sc.nextLine();
							System.out.println("Category:");
							category = sc.nextLine();
							System.out.println("Cost:");
							cost = Float.valueOf(sc.nextLine());
							System.out.println("dateAdded:");
							dateAdded = sc.nextLine();
							System.out.println("director:");
							director = sc.nextLine();
							System.out.println("Length:");
							length = Integer.valueOf(sc.nextLine());
							
							DigitalVideoDisc dvd = null;
							try {
								dvd = new DigitalVideoDisc(titledvd, category, cost, dateAdded, director,
										length);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
							}
							try {
								store.addMedia(dvd);
							} catch (LimitExceededException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case 2:
							String titlebook;
							String categorybook;
							float costbook;
							String dateAddedbook;
							String author;
							int lengthbook;
							System.out.println("Title:");
							titlebook = sc.nextLine();
							System.out.println("Category:");
							categorybook = sc.nextLine();
							System.out.println("Cost:");
							costbook = Float.valueOf(sc.nextLine());
							System.out.println("dateAdded:");
							dateAddedbook = sc.nextLine();
							System.out.println("author:");
							author = sc.nextLine();
							List<String> authors = new ArrayList<String>();
							authors.add(author);
							Book book = null;
							try {
								book = new Book(titlebook, categorybook, costbook, dateAddedbook, authors);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
							}
							try {
								store.addMedia(book);
							} catch (LimitExceededException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case 3:
							String titlecd;
							String categorycd;
							float costcd;
							String dateAddedcd;
							String artist;
							int lengthcd;
							String directorcd;
							System.out.println("Title:");
							titlecd = sc.nextLine();
							System.out.println("Category:");
							categorycd = sc.nextLine();
							System.out.println("Cost:");
							costcd = Float.valueOf(sc.nextLine());
							System.out.println("dateAdded:");
							dateAddedcd = sc.nextLine();
							System.out.println("director:");
							directorcd = sc.nextLine();
							System.out.println("artist:");
							artist = sc.nextLine();
							System.out.println("Length:");
							lengthcd = Integer.valueOf(sc.nextLine());
							ArrayList<Track> tracks = new ArrayList<Track>();
							Track track = new Track(titlecd, lengthcd);
							tracks.add(track);
							CompactDisc cd = null;
							try {
								cd = new CompactDisc(titlecd, categorycd, costcd, dateAddedcd, lengthcd, directorcd,
										artist, tracks);
							} catch (Exception e) {
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
							break;
						case 0:
							System.out.println("Exiting");
							notDone3 = true;
							break;
						default:
							System.out.println("Not an available option.");
						}
					//remove media
					case 2:
						System.out.println("Title of the media: ");
						String title5;
						title5 = sc.nextLine();
						if (store.searchByTitle(title5)) {
							Media m = store.getMediaByTitle(title5);
							try {
								store.removeMedia(m);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
							}
						}
						break;
					case 0:
						System.out.println("Exiting");
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				break;
			//see current cart
			case 3:
				int input4;
				boolean notDone4 = true;
				while (notDone4) {
					System.out.println("\n\n\n\n\n");
					cartMenu();
					input4 = Integer.valueOf(sc.nextLine());
					switch (input4) {
					//filter media
					case 1:
						System.out.println("Filter by id(1) or by name(2):");
						int filter = Integer.valueOf(sc.nextLine());
						if (filter == 1) {
							System.out.println("Id: ");
							int id = Integer.valueOf(sc.nextLine());
							cart.searchByID(id);
						}
						else if (filter == 2) {
							System.out.println("Title of the media: ");
							String title8;
							title8 = sc.nextLine();
							cart.searchByTitle(title8);
						}
						break;
					//sort media
					case 2:
						System.out.println("Sort by TitleCost(1) or CostTitle(2):");
						int sort = Integer.valueOf(sc.nextLine());
						if (sort == 1) {
							cart.sortByTitleCost();
							cart.printList();
						}
						else if (sort == 2) {
							cart.sortByCostTitle();
							cart.printList();
						}
						else {
							System.out.println("Invalid option");
						}
						break;
					//remove media from cart
					case 3:
						System.out.println("Title of the media: ");
						String title7;
						title7 = sc.nextLine();
						if (cart.searchByTitle(title7)) {
							Media m = store.getMediaByTitle(title7);
							try {
								cart.removeMedia(m);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
							}
						}
						break;
					//play a media
					case 4:
						cart.printList();
						System.out.println("Title of the media: ");
						String title5;
						title5 = sc.nextLine();
						if (cart.searchByTitle(title5)) {
							Media m = cart.getMediaByTitle(title5);
							if (m.getClass().equals(DigitalVideoDisc.class)) {
								DigitalVideoDisc item = (DigitalVideoDisc) m;
								try {
									item.play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									JFrame f = new JFrame();
									JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
								}
							}
							else if (m.getClass().equals(CompactDisc.class)) {
								CompactDisc item = (CompactDisc) m;
								try {
									item.play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									JFrame f = new JFrame();
									JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
								}
							}
							else System.out.println("Media not playable");
						}
						break;
					//place order
					case 5:
						System.out.println("An order is created");
						cart.emptyCart();
						break;
					case 0:
						notDone4 = false;
						System.out.println("Exiting");
						break;
					default:
						System.out.println("Not an available option. Please choose again\n");
					}
				}
				break;
			//exit
			case 0:
				notDone1 = false;
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Not an available option. Please choose again\n");
			}
		}
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("_________________________________");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("_________________________________");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("_________________________________");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart ");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("_________________________________");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("_________________________________");
		System.out.println("1. Add media");
		System.out.println("2. Remove media");
		System.out.println("0. Exit");
		System.out.println("_________________________________");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("_________________________________");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart ");
		System.out.println("3. Remove media from cart ");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("_________________________________");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
}















