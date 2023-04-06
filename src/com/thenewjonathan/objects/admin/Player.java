package com.thenewjonathan.objects.admin;

import com.thenewjonathan.enums.*;
import com.thenewjonathan.heros.superclasses.Combatant;
import com.thenewjonathan.objects.usables.Armor;
import com.thenewjonathan.objects.usables.Card;
import com.thenewjonathan.objects.usables.Weapon;
import com.thenewjonathan.userinterface.CommonFunctions;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Player
{
	private String name;
	private String playerId;
	private ArrayList<Combatant> combatants;
	private Random rand = new Random();

	public Player(String name)
	{
		generatePlayerId();
		setUpCombatants();
	}

	public Player(String name, String playerId, ArrayList<Combatant> combatants)
	{
		setName(name);
		if (!playerId.isEmpty())
		{
			setPlayerId(playerId);
		}
		else
		{
			generatePlayerId();
		}
		setCombatants(combatants == null ? new ArrayList<Combatant>() : combatants);
	}

	public Player copy()
	{
		return new Player(name, playerId, combatants);
	}

	public void generatePlayerId()
	{
		playerId = "";
		for (int i = 0; i < 10; i++)
		{
			if(i%2 == 0)
			{
				playerId += String.valueOf((char) rand.nextInt(26) + 'a');
			}
			else
			{
				playerId += String.valueOf(rand.nextInt(10));
			}
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		return getPlayerId().equals(((Player) obj).getPlayerId());
	}

	public void setUpCombatants()
	{
		combatants = new ArrayList<Combatant>();
		setCombatants(getExistingCombatants());
		// do stuff here with prompts to set up the characters... will do later when I'm good with Android stuff
		// so I'm not wasting time doing it with sysout's or whatever here...
	}

	public void addCombatant(Combatant c)
	{
		combatants.add(c);
	}

	public void backUpCombatants()
	{
		ArrayList<Combatant> allCombatants = getCombatants();
		for (Combatant c : getExistingCombatants())
		{
			if (!allCombatants.contains(c))
			{
				allCombatants.add(c);
			}
		}
		File newXmlFile = new File("old_heros.xml");
		try
		{
			OutputStream outputStream = new FileOutputStream(newXmlFile);
			XMLStreamWriter out =
					XMLOutputFactory.newInstance().createXMLStreamWriter(new OutputStreamWriter(outputStream, "utf-8"));
			out.writeStartDocument();
			for (Combatant c : allCombatants)
			{
				CommonFunctions.say("Writing " + c);
				out.writeStartElement("newCombatant");
				out.writeAttribute("name", c.getName());
				out.writeAttribute("class", c.getClass().getSimpleName());
				out.writeAttribute("gender", c.getGender().toString());
				out.writeAttribute("level", String.valueOf(c.getLevel()));
				out.writeAttribute("strength", String.valueOf(c.getStrength()));
				out.writeAttribute("agility", String.valueOf(c.getAgility()));
				out.writeAttribute("intelligence", String.valueOf(c.getIntelligence()));
				out.writeAttribute("accuracy", String.valueOf(c.getAccuracy()));
				out.writeAttribute("wisdom", String.valueOf(c.getWisdom()));
				out.writeAttribute("constitution", String.valueOf(c.getConstitution()));
				out.writeAttribute("weaponProficiency", String.valueOf(c.getWeaponProficiency()));
				out.writeAttribute("will", String.valueOf(c.getWill()));
				out.writeAttribute("xp", String.valueOf(c.getXp()));
				out.writeAttribute("maxLive", String.valueOf(c.getMaxLife()));
				out.writeAttribute("maxStamina", String.valueOf(c.getMaxStamina()));
				out.writeAttribute("dualWield", c.isDualWield() ? "true" : "false");
				out.writeStartElement("weaponProficiencyTypes");
				int ctr = 1;
				for (WeaponTypes wt : c.getWeaponProficiencyTypes())
				{
					if (ctr > 1)
					{
						out.writeCharacters("/");
					}
					out.writeCharacters(wt.toString());
					ctr++;
				}
				out.writeEndElement(); // weaponProficiencyTypes
				out.writeStartElement("library");
				ctr = 1;
				for (Card card : c.getLibrary())
				{
					if (ctr > 1)
					{
						out.writeCharacters("/");
					}
					out.writeCharacters(card.getName());
					ctr++;
				}
				out.writeEndElement(); // library
				out.writeStartElement("lastDeckPlayed");
				ctr = 1;
				for (String s : c.getLastDeckPlayed())
				{
					if (ctr > 1)
					{
						out.writeCharacters("/");
					}
					out.writeCharacters(s);
					ctr++;
				}
				out.writeEndElement(); // lastDeckPlayed
				out.writeStartElement("weaponsCache");
				ctr = 1;
				for (Weapon w : c.getWeaponsCache())
				{
					if (ctr > 1)
					{
						out.writeCharacters("/");
					}
					out.writeCharacters(w.getName());
					ctr++;
				}
				out.writeEndElement(); // weaponsCache
				out.writeStartElement("armorCache");
				ctr = 1;
				for (Armor a : c.getArmorCache())
				{
					if (ctr > 1)
					{
						out.writeCharacters("/");
					}
					out.writeCharacters(a.getName());
					ctr++;
				}
				out.writeEndElement(); // armorCache
				out.writeEndElement(); // newCombatant
			}
			out.writeEndDocument();
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<Combatant> getExistingCombatants()
	{
		final ArrayList<Combatant> currentCombatants = new ArrayList<Combatant>();

		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler()
			{
				boolean inElement = false;
				String currentString = null;
				Combatant temp = null;
				String heroClassString = null;
				Class<?> heroClass = null;

				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException
				{
					currentString = null;

					if (qName.equalsIgnoreCase("newCombatant"))
					{
						inElement = true;
						temp = null;
						heroClassString = attributes.getValue("class");
						try
						{
							heroClass = Class.forName(Constants.HERO_CLASSES_FOLDER + heroClassString);
							temp = (Combatant) heroClass.newInstance();
							temp.setName(attributes.getValue("name"));
							temp.setGender(attributes.getValue("gender").equalsIgnoreCase("Male") ? Genders.MALE :
									Genders.FEMALE);
							temp.setLevel(Integer.valueOf(attributes.getValue("level")));
							temp.setStrength(Integer.valueOf(attributes.getValue("strength")));
							temp.setAgility(Integer.valueOf(attributes.getValue("agility")));
							temp.setIntelligence(Integer.valueOf(attributes.getValue("intelligence")));
							temp.setAccuracy(Integer.valueOf(attributes.getValue("accuracy")));
							temp.setWisdom(Integer.valueOf(attributes.getValue("wisdom")));
							temp.setConstitution(Integer.valueOf(attributes.getValue("constitution")));
							temp.setWill(Integer.valueOf(attributes.getValue("will")));
							temp.setWeaponProficiency(Integer.valueOf(attributes.getValue("weaponProficiency")));
							temp.setWeaponProficiencyTypes(new ArrayList<WeaponTypes>());
							temp.setWeaponsInPlay(new ArrayList<Weapon>());
							temp.setArmorInPlay(new ArrayList<Armor>());
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
					if (qName.equalsIgnoreCase("weaponProficiencyTypes"))
					{
						inElement = true;
					}
					if (qName.equalsIgnoreCase("library"))
					{
						inElement = true;
					}
					if (qName.equalsIgnoreCase("lastDeckPlayed"))
					{
						inElement = true;
					}
					if (qName.equalsIgnoreCase("weaponsCache"))
					{
						inElement = true;
					}
					if (qName.equalsIgnoreCase("armorCache"))
					{
						inElement = true;
					}
				}

				public void endElement(String uri, String localName, String qName) throws SAXException
				{
					String splitString[] = null;

					if (qName.equalsIgnoreCase("newCombatant"))
					{
						inElement = false;
						currentCombatants.add(temp.clone());
					}
					if (qName.equalsIgnoreCase("weaponProficiencyTypes"))
					{
						inElement = false;
						splitString = currentString.split("/");
						for (String s : splitString)
						{
							temp.getWeaponProficiencyTypes().add(WeaponTypes.getTypeByName(s));
						}
					}
					if (qName.equalsIgnoreCase("library"))
					{
						inElement = false;
						splitString = currentString.split("/");
						for (String s : splitString)
						{
							Card tempCard = null;
							tempCard = Spells.getSpellByName(s);
							if (tempCard == null)
							{
								tempCard = Actions.getActionByName(s);
							}
							if (tempCard == null)
							{
								CommonFunctions.say("Error loading card " + s);
							}
							else
							{
								temp.getLibrary().add(tempCard);
							}
						}
					}
					if (qName.equalsIgnoreCase("lastDeckPlayed"))
					{
						inElement = false;
						splitString = currentString.split("/");
						for (String s : splitString)
						{
							temp.getLastDeckPlayed().add(s);
						}
					}
					if (qName.equalsIgnoreCase("weaponsCache"))
					{
						inElement = false;
						splitString = currentString.split("/");
						for (String s : splitString)
						{
							Weapon tempWeapon = Weapons.getWeaponByName(s);
							if (tempWeapon == null)
							{
								CommonFunctions.say("Error loading weapon");
							}
							else
							{
								temp.getWeaponsCache().add(tempWeapon);
							}
						}
					}
					if (qName.equalsIgnoreCase("armorCache"))
					{
						inElement = false;
						splitString = currentString.split("/");
						for (String s : splitString)
						{
							Armor tempArmor = Armors.getArmorByName(s);
							if (tempArmor == null)
							{
								CommonFunctions.say("Error loading armor");
							}
							else
							{
								temp.getArmorCache().add(tempArmor);
							}
						}
					}
				}

				public void characters(char ch[], int start, int length) throws SAXException
				{
					if (inElement)
					{
						currentString = new String(ch, start, length);
					}
				}
			};
			saxParser.parse("old_heros.xml", handler);
		}
		catch (ParserConfigurationException e1)
		{
			e1.printStackTrace();
		}
		catch (SAXException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentCombatants;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPlayerId()
	{
		return playerId;
	}

	public void setPlayerId(String playerId)
	{
		this.playerId = playerId;
	}

	public ArrayList<Combatant> getCombatants()
	{
		return combatants;
	}

	public void setCombatants(ArrayList<Combatant> combatants)
	{
		this.combatants = combatants;
	}
}
