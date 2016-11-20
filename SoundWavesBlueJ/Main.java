import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Background Image
	final Image pianoBackground = ImageIO.read(new File("../finall_piano_screen.png"));
    final Image drumBackground = ImageIO.read(new File("../finall_drum_screen.png"));
    
    // Outline Images
    final Image recordDrumSOutline = ImageIO.read(new File("../stop_record_replay_outline.png"));
    final Image stopDrumSOutline = ImageIO.read(new File("../stop_record_replay_outline.png"));
    final Image replayDrumSOutline = ImageIO.read(new File("../stop_record_replay_outline.png"));
    final Image loopDrumSOutline = ImageIO.read(new File("../loop_button_outline.png"));
    final Image tempoUpDrumSOutline = ImageIO.read(new File("../tempoup_down_loop_switch_outline.png"));
    final Image tempoDownDrumSOutline = ImageIO.read(new File("../tempoup_down_loop_switch_outline.png"));
    final Image switchDrumSOutline = ImageIO.read(new File("../switch_outline.png"));
    final Image hiHatDrumSOutline = ImageIO.read(new File("../new_hihatcymbal_outline.png"));
    final Image snareDrumSOutline = ImageIO.read(new File("../new_snaredrum_outline.png"));
    final Image bassDrumSOutline = ImageIO.read(new File("../new_bassdrum_outline.png"));
    final Image s1DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image s2DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image s3DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image s4DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image s5DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image s6DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image s7DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image s8DrumSOutline = ImageIO.read(new File("../8soundbuttons_outline.png"));
    final Image recordPianoSOutline = ImageIO.read(new File("../stop_record_replay_outline.png"));
    final Image stopPianoSOutline = ImageIO.read(new File("../stop_record_replay_outline.png"));
    final Image replayPianoSOutline = ImageIO.read(new File("../stop_record_replay_outline.png"));
    final Image loopPianoSOutline = ImageIO.read(new File("../tempoup_down_loop_switch_outline.png"));
    final Image tempoUPPianoSOutline = ImageIO.read(new File("../tempoup_down_loop_switch_outline.png"));
    final Image tempoDownPianoSOutline = ImageIO.read(new File("../tempoup_down_loop_switch_outline.png"));
    final Image switchPianoSOutline = ImageIO.read(new File("../switch_outline.png"));
    final Image ku1PianoSOutline = ImageIO.read(new File("../black_key_outline.png"));
    final Image ku2PianoSOutline = ImageIO.read(new File("../black_key_outline.png"));
    final Image ku3PianoSOutline = ImageIO.read(new File("../black_key_outline.png"));
    final Image ku4PianoSOutline = ImageIO.read(new File("../black_key_outline.png"));
    final Image ku5PianoSOutline = ImageIO.read(new File("../black_key_outline.png"));
    final Image kl1PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    final Image kl2PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    final Image kl3PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    final Image kl4PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    final Image kl5PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    final Image kl6PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    final Image kl7PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    final Image kl8PianoSOutline = ImageIO.read(new File("../cut_off_white_key_outline.png"));
    
	// Sound Files
    final File a = new File("../SoundFiles/piano/long/a.wav");
    final File ab = new File("../SoundFiles/piano/long/ab.wav");
    final File b = new File("../SoundFiles/piano/long/b.wav");
    final File bb = new File("../SoundFiles/piano/long/bb.wav");
    final File c = new File("../SoundFiles/piano/long/c.wav");
    final File d = new File("../SoundFiles/piano/long/d.wav");
    final File db = new File("../SoundFiles/piano/long/db.wav");
    final File note_e = new File("../SoundFiles/piano/long/e.wav");
    final File eb = new File("../SoundFiles/piano/long/eb.wav");
    final File note_f = new File("../SoundFiles/piano/long/f.wav");
    final File g = new File("../SoundFiles/piano/long/g.wav");
    final File gb = new File("../SoundFiles/piano/long/gb.wav");
    final File highc = new File("../SoundFiles/piano/long/highc.wav");
    final File record = new File("../SoundFiles/piano/268160_thirteenthfail_enemy-red.wav");
	final File hiHatNoise = new File("../SoundFiles/Drum/Hi-Hat.wav");
	final File snareNoise = new File("../SoundFiles/Drum/Snare_Drum.wav");
	final File bassNoise = new File("../SoundFiles/Drum/Bass_Drum.wav");
	final File specialSound1 = new File("../SoundFiles/golf_swing.wav"); 
	final File specialSound2 = new File("../SoundFiles/wav/baboon1.wav");
	final File specialSound3 = new File("../SoundFiles/wav/Ball+Hit+Cheer.wav");
	final File specialSound4 = new File("../SoundFiles/wav/bark.wav");
	final File specialSound5 = new File("../SoundFiles/wav/bear-roar.wav");
	final File specialSound6 = new File("../SoundFiles/wav/bowling2.wav");
	final File specialSound7 = new File("../SoundFiles/wav/camel2.wav");
	final File specialSound8 = new File("../SoundFiles/wav/Cheetah2.wav");

	ArrayList<File> playOld = new ArrayList<File>();
	ArrayList<Double> timeOld = new ArrayList<Double>();
    double startTimeOld = 0;
	ArrayList<File> play = new ArrayList<File>();
	ArrayList<Double> time = new ArrayList<Double>();
    double startTime = -1;
    int playbackIndex = -1;
    boolean loop = false;
    boolean pianoScreen = false;
    double replayStart;
    
    // Visual toggles
    boolean recordDrumSOutlineOn = false;
    boolean stopDrumSOutlineOn = false;
    boolean replayDrumSOutlineOn = false;
    boolean loopDrumSOutlineOn = false;
    boolean tempoUpDrumSOutlineOn = false;
    boolean tempoDownDrumSOutlineOn = false;
    boolean switchDrumSOutlineOn = false;
    boolean hiHatDrumSOutlineOn = false;
    boolean snareDrumSOutlineOn = false;
    boolean bassDrumSOutlineOn = false;
    boolean s1DrumSOutlineOn = false;
    boolean s2DrumSOutlineOn = false;
    boolean s3DrumSOutlineOn = false;
    boolean s4DrumSOutlineOn = false;
    boolean s5DrumSOutlineOn = false;
    boolean s6DrumSOutlineOn = false;
    boolean s7DrumSOutlineOn = false;
    boolean s8DrumSOutlineOn = false;
    boolean recordPianoSOutlineOn = false;
    boolean stopPianoSOutlineOn = false;
    boolean replayPianoSOutlineOn = false;
    boolean loopPianoSOutlineOn = false;
    boolean tempoUPPianoSOutlineOn = false;
    boolean tempoDownPianoSOutlineOn = false;
    boolean switchPianoSOutlineOn = false;
    boolean ku1PianoSOutlineOn = false;
    boolean ku2PianoSOutlineOn = false;
    boolean ku3PianoSOutlineOn = false;
    boolean ku4PianoSOutlineOn = false;
    boolean ku5PianoSOutlineOn = false;
    boolean kl1PianoSOutlineOn = false;
    boolean kl2PianoSOutlineOn = false;
    boolean kl3PianoSOutlineOn = false;
    boolean kl4PianoSOutlineOn = false;
    boolean kl5PianoSOutlineOn = false;
    boolean kl6PianoSOutlineOn = false;
    boolean kl7PianoSOutlineOn = false;
    boolean kl8PianoSOutlineOn = false;

	public void playSound(File f)
	{	
		if (startTime > 0)
		{
			time.add(System.currentTimeMillis() - startTime);
	        play.add(f);
		}
		
		try {
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(f);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		    
		    LineListener listener = new LineListener() {
		        public void update(LineEvent event) {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    clip.close();
	                    event.getLine().close();
	                }
		        }
		    };
		clip.addLineListener(listener );
		}
		catch (Exception e) {
		  e.printStackTrace();
		  System.exit(1);		
        }
	}
	
	public Main() throws IOException
	{
		JFrame f = new JFrame("SoundWaves");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(1024, 808);
                
        JPanel pane = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (pianoScreen)
                {
                	g.drawImage(pianoBackground, 0, 0, null);
                	
	                // Outline Toggles
                	if (recordPianoSOutlineOn)
	                    g.drawImage(recordPianoSOutline, 142, 625, null);
	                if (stopPianoSOutlineOn)
	                    g.drawImage(stopPianoSOutline, 0, 625, null);
	                if (replayPianoSOutlineOn)
	                    g.drawImage(replayPianoSOutline, 288, 625, null);
	                if (loopPianoSOutlineOn)
	                    g.drawImage(loopPianoSOutline, 430, 690, null);
	                if (tempoUPPianoSOutlineOn)
	                    g.drawImage(tempoUPPianoSOutline, 575, 619, null);
	                if (tempoDownPianoSOutlineOn)
	                    g.drawImage(tempoDownPianoSOutline, 430, 615, null);
	                if (switchPianoSOutlineOn)
	                    g.drawImage(switchPianoSOutline, 882, 482, null); // Doesn't matter
	                if (ku1PianoSOutlineOn)
	                    g.drawImage(ku1PianoSOutline, 125, 85, null);
	                if (ku2PianoSOutlineOn)
	                    g.drawImage(ku2PianoSOutline, 232, 85, null);
	                if (ku3PianoSOutlineOn)
	                    g.drawImage(ku3PianoSOutline, 450, 85, null);
	                if (ku4PianoSOutlineOn)
	                    g.drawImage(ku4PianoSOutline, 557, 85, null);
	                if (ku5PianoSOutlineOn)
	                    g.drawImage(ku5PianoSOutline, 664, 85, null);
	                if (kl1PianoSOutlineOn)
	                    g.drawImage(kl1PianoSOutline, 73, 376, null);
	                if (kl2PianoSOutlineOn)
	                    g.drawImage(kl2PianoSOutline, 179, 376, null);
	                if (kl3PianoSOutlineOn)
	                    g.drawImage(kl3PianoSOutline, 291, 376, null);
	                if (kl4PianoSOutlineOn)
	                    g.drawImage(kl4PianoSOutline, 398, 376, null);
	                if (kl5PianoSOutlineOn)
	                    g.drawImage(kl5PianoSOutline, 505, 376, null);
	                if (kl6PianoSOutlineOn)
	                    g.drawImage(kl6PianoSOutline, 613, 376, null);
	                if (kl7PianoSOutlineOn)
	                    g.drawImage(kl7PianoSOutline, 718, 376, null);
	                if (kl8PianoSOutlineOn)
	                    g.drawImage(kl8PianoSOutline, 829, 376, null);
	                
                }
                else
                {
	                g.drawImage(drumBackground, 0, 0, null);
	                
	                // Outline Toggles
	                if (recordDrumSOutlineOn)
	                    g.drawImage(recordDrumSOutline, 882, 482, null);
	                if (stopDrumSOutlineOn)
	                    g.drawImage(stopDrumSOutline, 882, 627, null);
	                if (replayDrumSOutlineOn)
	                    g.drawImage(replayDrumSOutline, 882, 337, null);
	                if (loopDrumSOutlineOn)
	                    g.drawImage(loopDrumSOutline, 882, 144, null);
	                if (tempoUpDrumSOutlineOn)
	                    g.drawImage(tempoUpDrumSOutline, 882, 200, null);
	                if (tempoDownDrumSOutlineOn)
	                    g.drawImage(tempoDownDrumSOutline, 882, 265, null);
	                if (switchDrumSOutlineOn)
	                    g.drawImage(switchDrumSOutline, 882, 100, null); // not necessary
	                if (hiHatDrumSOutlineOn)
	                    g.drawImage(hiHatDrumSOutline, 53, 222, null);
	                if (snareDrumSOutlineOn)
	                    g.drawImage(snareDrumSOutline, 325, 498, null);
	                if (bassDrumSOutlineOn)
	                    g.drawImage(bassDrumSOutline, 480, 228, null);
	                if (s1DrumSOutlineOn)
	                    g.drawImage(s1DrumSOutline, 0, 0, null);
	                if (s2DrumSOutlineOn)
	                    g.drawImage(s2DrumSOutline, 215, 0, null);
	                if (s3DrumSOutlineOn)
	                    g.drawImage(s3DrumSOutline, 430, 0, null);
	                if (s4DrumSOutlineOn)
	                    g.drawImage(s4DrumSOutline, 645, 0, null);
	                if (s5DrumSOutlineOn)
	                    g.drawImage(s5DrumSOutline, 0, 70, null);
	                if (s6DrumSOutlineOn)
	                    g.drawImage(s6DrumSOutline, 215, 70, null);
	                if (s7DrumSOutlineOn)
	                    g.drawImage(s7DrumSOutline, 430, 70, null);
	                if (s8DrumSOutlineOn)
	                    g.drawImage(s8DrumSOutline, 645, 70, null);
                }

            }
        };
        f.add(pane);
        
        f.addKeyListener(new KeyListener() {
          
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyChar())
                {
                	// Special Noises
                	case 'z':
                		if (!pianoScreen)
                		{
                			s1DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound1);
	                	break;
                	case 'x':
                		if (!pianoScreen)
                		{
                			s2DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound2);
	                	break;
                	case 'c':
                		if (!pianoScreen)
                		{
                			s3DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound3);
	                	break;
                	case 'v':
                		if (!pianoScreen)
                		{
                			s4DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound4);
	                	break;
                	case 'b':
                		if (!pianoScreen)
                		{
                			s5DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound5);
	                	break;
                	case 'n':
                		if (!pianoScreen)
                		{
                			s6DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound6);
	                	break;
                	case 'm':
                		if (!pianoScreen)
                		{
                			s7DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound7);
	                	break;
                	case ',':
                		if (!pianoScreen)
                		{
                			s8DrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(specialSound8);
	                	break;
	                // Drum Noises
                	case 'i':
                		if (!pianoScreen)
                		{
                			hiHatDrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(hiHatNoise);
	                	break;
                	case 'o':
                		if (!pianoScreen)
                		{
                			snareDrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(snareNoise);
	                	break;
                	case 'p':
                		if (!pianoScreen)
                		{
                			bassDrumSOutlineOn = true;
	                		pane.repaint();
                		}
	                	playSound(bassNoise);
	                	break;
	                // Piano Noises
                	case 'a':
                		if (pianoScreen)
                		{
                			kl1PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(c);
                	    break;
                	case 'w':
                		if (pianoScreen)
                		{
                			ku1PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(db);
                	    break;
                	case 's':
                		if (pianoScreen)
                		{
                			kl2PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(d);
                	    break;
                	case 'e':
                		if (pianoScreen)
                		{
                			ku2PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(eb);
                	    break;
                	case 'd':
                		if (pianoScreen)
                		{
                			kl3PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(note_e);
                	    break;
                	case 'f':
                		if (pianoScreen)
                		{
                			kl4PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(note_f);
                	    break;
                	case 't':
                		if (pianoScreen)
                		{
                			ku3PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(gb);
                	    break;
                	case 'g':
                		if (pianoScreen)
                		{
                			kl5PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(g);
                	    break;
                	case 'y':
                		if (pianoScreen)
                		{
                			ku4PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(ab);
                	    break;
                	case 'h':
                		if (pianoScreen)
                		{
                			kl6PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(a);
                	    break;
                	case 'u':
                		if (pianoScreen)
                		{
                			ku5PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(bb);
                	    break;
                	case 'j':
                		if (pianoScreen)
                		{
                			kl7PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(b);
                	    break;
                	case 'k':
                		if (pianoScreen)
                		{
                			kl8PianoSOutlineOn = true;
	                		pane.repaint();
                		}
                	    playSound(highc);
                	    break;
	                /* Commands keys */
                	// Stop Recording
                	case '1':
                		if (startTime >= 0)
                		{
	                		System.out.println("Stop recording");
	                		if (pianoScreen)
	                			stopPianoSOutlineOn = true;
	                		else
	                			stopDrumSOutlineOn = true;
	                		pane.repaint();
	                		playbackIndex = -1;
	                        startTime = -1;
	                        startTimeOld = startTime;
	                        playOld.clear();
	                        timeOld.clear();
	                        for (int i = 0; i < time.size(); i++)
	                        {
	                        	playOld.add(play.get(i));
	                        	timeOld.add(time.get(i));
	                        }
                		}
                		else
                			System.out.println("Not recording");
                		break;
	                // Start Recording
                	case '2':
                		if (startTime < 0)
                		{
	                		System.out.println("Start recording");
	                		if (pianoScreen)
	                			recordPianoSOutlineOn = true;
	                		else
	                			recordDrumSOutlineOn = true;
	                		pane.repaint();
	                		play.clear();
	                		time.clear();
	                        startTime = System.currentTimeMillis();
                		}
                		else
                			System.out.println("Currently recording");
                		break;
                	// Playback Recording
                	case '3':
                		System.out.println("Playback");
                		if (pianoScreen)
                			replayPianoSOutlineOn = true;
                		else
                			replayDrumSOutlineOn = true;
                		pane.repaint();
                		if (playbackIndex < 0 || playbackIndex >= timeOld.size())
                		{
	                		playbackIndex = 0;
	                        replayStart = System.currentTimeMillis();
                		}
                		else
                			System.out.println("Can't playback recording");
                		break;
                	case '6':
                		if (pianoScreen)
                			loopPianoSOutlineOn = true;
                		else
                			loopDrumSOutlineOn = true;
                		pane.repaint();
                		loop = !loop;
                		if (loop)
                			System.out.println("Loop on");
                		else
                			System.out.println("Loop off");
                        break;
                	case '4':
                		if (playbackIndex < 0 || playbackIndex >= timeOld.size())
                		{
	                		System.out.println("Decrease tempo by 2");
	                		if (pianoScreen)
	                			tempoDownPianoSOutlineOn = true;
	                		else
	                			tempoDownDrumSOutlineOn = true;
                    		pane.repaint();
							int i = 0;
							while(i < timeOld.size())
							{
								timeOld.set(i, timeOld.get(i)*2);
						        i++;
							}
                		}
                		else
                			System.out.println("Can't change tempo during playback");
                		break;
                	case '5':
                		if (playbackIndex < 0 || playbackIndex >= timeOld.size())
                		{
	                		System.out.println("Increase tempo by 2");
	                		if (pianoScreen)
	                			tempoUPPianoSOutlineOn = true;
	                		else
	                			tempoUpDrumSOutlineOn = true;
	                		pane.repaint();
	                		int i = 0;
	                        while(i < timeOld.size())
	                        {
	                    		timeOld.set(i, timeOld.get(i)/2);
	                            i++;
	                        } 
	                        break;
                		}
                		else
                			System.out.println("Can't change tempo during playback");
                	case '7':
                		if (pianoScreen)
                			switchPianoSOutlineOn = true;
                		else
                			switchDrumSOutlineOn = true;
                		pane.repaint();
                	    pianoScreen = !pianoScreen;
                	    pane.repaint();
                		if (pianoScreen)
                			System.out.println("Switched to piano screen");
                		else
                			System.out.println("Switched to drum screen");
                		break;
                }
            }

			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				switch(arg0.getKeyChar())
		        {
		            case '2':
		                recordDrumSOutlineOn = false;
		                recordPianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case '1':
		                stopDrumSOutlineOn = false;
		                stopPianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case '3':
		                replayDrumSOutlineOn = false;
		                replayPianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case '6':
		                loopDrumSOutlineOn = false;
		                loopPianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case '5':
		                tempoUpDrumSOutlineOn = false;
		                tempoUPPianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case '4':
		                tempoDownDrumSOutlineOn = false;
		                tempoDownPianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case '7':
		                switchDrumSOutlineOn = false;
		                switchPianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'i':
                		hiHatDrumSOutlineOn = false;
                		pane.repaint();
	                	break;
                	case 'o':
                		snareDrumSOutlineOn = false;
                		pane.repaint();
	                	break;
                	case 'p':
                		bassDrumSOutlineOn = false;
                		pane.repaint();
	                	break;
		            case 'z':
		                s1DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'x':
		                s2DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'c':
		                s3DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'v':
		                s4DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'b':
		                s5DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'n':
		                s6DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'm':
		                s7DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case ',':
		                s8DrumSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'w':
		                ku1PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'e':
		                ku2PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 't':
		                ku3PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'y':
		                ku4PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'u':
		                ku5PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'a':
		                kl1PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 's':
		                kl2PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'd':
		                kl3PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'f':
		                kl4PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'g':
		                kl5PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'h':
		                kl6PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'j':
		                kl7PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		            case 'k':
		                kl8PianoSOutlineOn = false;
		                pane.repaint();
		                break;
		        }
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });

        while (true)
        {
        	// If playback enabled, play the sounds in it
            if (playbackIndex >= 0 && playbackIndex < timeOld.size())
            {
    	        if (timeOld.get(playbackIndex) - startTimeOld < System.currentTimeMillis() - replayStart)
    	        {
    	            playSound(playOld.get(playbackIndex));
    	            playbackIndex++;
    	            
    	            if (loop && playbackIndex >= timeOld.size())
    	            {
    	            	playbackIndex = 0;
    	            	replayStart = System.currentTimeMillis();
    	            }
    	        }
            }
            
            try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
	}
	
	public static void main(String[] args) throws Exception 
	{
		new Main();
	}
}