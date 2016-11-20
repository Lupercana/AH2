import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.sound.sampled.LineEvent.Type;
import javax.swing.JComponent;
import javax.swing.JFrame;

class ImagePanel extends JComponent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

public class Main {
	
	// Background Image
	final static File bg = new File("../new_screen_for_SoundWaves.png");
	
	// Sound Files
	final static File hiHatNoise = new File("../SoundFiles/Drum/Hi-Hat.wav");
	final static File snareNoise = new File("../SoundFiles/Drum/Snare_Drum.wav");
	final static File bassNoise = new File("../SoundFiles/Drum/Bass_Drum.wav");
	final static File golfNoise = new File("../SoundFiles/golf_swing.wav"); 
	final static File baboon1 = new File("../SoundFiles/wav/baboon1.wav");
	final static File ballhitcheer = new File("../SoundFiles/wav/Ball+Hit+Cheer.wav");
	final static File bark = new File("../SoundFiles/wav/bark.wav");
	final static File bearroar = new File("../SoundFiles/wav/bear-roar.wav");
	final static File bowling2 = new File("../SoundFiles/wav/bowling2.wav");
	final static File camel2 = new File("../SoundFiles/wav/camel2.wav");
	final static File Cheetah2 = new File("../SoundFiles/wav/Cheetah2.wav");
	final static File dSHAKE = new File("../SoundFiles/wav/dSHAKE.wav");
	final static File golfball= new File("../SoundFiles/wav/golfball.wav");
	final static File koala = new File("../SoundFiles/wav/koala%5B1%5D.wav");
	
	static ArrayList<File> play = new ArrayList<File>();
	static ArrayList<Double> time = new ArrayList<Double>();
    static double startTime = 0;
	
	public static void playSound(File f)
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
	                if (event.getType() == Type.STOP) {
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
	
	public static void main(String[] args) throws Exception 
	{
        JFrame f = new JFrame("SoundWaves");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage myImage = ImageIO.read(bg);
        f.setContentPane(new ImagePanel(myImage));
        f.setVisible(true);
        f.setSize(1024, 800);
        
        //loadAllClips();
        
        f.addKeyListener(new KeyListener() {
          
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyChar())
                {
                	case 'd':
	                	playSound(koala);
	                	break;
                	case 'h':
	                	playSound(golfball);
	                	break;
                	case 'y':
	                	playSound(dSHAKE);
	                	break;
                	case 'q':
	                	playSound(Cheetah2);
	                	break;
                	case 'w':
	                	playSound(bearroar);
	                	break;
                	case 'e':
	                	playSound(camel2);
	                	break;
                	case 'r':
	                	playSound(bowling2);
	                	break;
                	case 't':
	                	playSound(bark);
	                	break;
                	case 'a':
	                	playSound(ballhitcheer);
	                	break;
                	case 's':
	                	playSound(baboon1);
	                	break;
                	case 'g':
	                	playSound(golfNoise);
	                	break;
                	case 'j':
	                	playSound(hiHatNoise);
	                	break;
                	case 'k':
	                	playSound(snareNoise);
	                	break;
                	case 'l':
	                	playSound(bassNoise);
	                	break;
	                // Start Recording
                	case 'z':
                		System.out.println("Start Recording");
                		play.clear();
                		time.clear();
                        startTime = System.currentTimeMillis();    
                		break;
                	// Stop Recording
                	case 'x':
                		System.out.println("Stop Recording");
                        startTime = -1;
                		break;
                	// Playback Recording
                	case 'c':
                		System.out.println("Playback");
                		if (startTime <= 0)
                		{
	                		double replayStart = System.currentTimeMillis();
	
	                        int i = 0;
	                        while(i < play.size())
	                        {
                                if (time.get(i) - startTime < System.currentTimeMillis() - replayStart)
                                {
                                    playSound(play.get(i));
                                    i++;
                                }
	                        }
                		}
                		break;
                	// TODO: Toggle loop
                	case 'v':
                		double maxTime = time.get(0) - startTime;
                        int k = 0;
                        while (k < time.size() - 1)
                        {
                            if ((time.get(k + 1) - time.get(k)) > maxTime)
                            {
                                maxTime = time.get(k + 1) - time.get(k);
                            }
                            k++;
                        }
                        double maxTimeUp = Math.round(maxTime/1000) + 1;
                        int j = 0;
                        while (j < maxTimeUp)
						{
						    double replayStart = System.currentTimeMillis();
						    int i = 0;
						    while(i < play.size())
						    {
						        if (time.get(i) - startTime < System.currentTimeMillis() - replayStart)
						        {
						            playSound(play.get(i));
						            i++;
						        }
						    }
						    j++;
						}
                        break;
                }
            }

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
	}
}