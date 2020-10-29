/**
 * The Distribution in Whole or in Some Part is forbidden without Permission.
 */

package root;
/**
 * imported required packages and classes file. DO NOT MODIFY!!!
 */
import gnu.io.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;
import org.opencv.videoio.VideoCapture;
/**
 * This is main class called MainDataCollectorFrame.
 * This class extends JFrame and implements SerialPortEventListener.
 */
public class MainDataCollectorFrame extends JFrame implements SerialPortEventListener{
    /**
     * This is member variable DO NOT EDIT!!!!
     * faceDetector load .xml file for Recognition of Face
     * eyeDetector load .xml file for Recognition of Eye
     * switcher is used to switch HCSR041 to HCSR042
     */
    private final CascadeClassifier faceDetector = new CascadeClassifier("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
    private final CascadeClassifier eyeDetector = new CascadeClassifier("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_eye.xml");
    private boolean switcher = true;
    /**
     * serialPort will contain the exact port Name which will be used for collecting data.
     */
    private SerialPort serialPort;
    /**
     * PORT_NAMES will contain the various port name used on OS like windows, Mac, Linux, etc.
     */
    private static final String PORT_NAMES[] = { "COM3", "/dev/tty.usbserial-A9007UX1", "/dev/ttyACM0", "/dev/ttyUSB0"};
    /**
     * BufferedReader is the variable which reads the data from console which is written by arduino uno.
     */
    private BufferedReader input;
    /**
     * TIME_OUT is waiting time for data to read.
     * DATA_RATE is buad rate of the arduino uno
     */
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    
    public MainDataCollectorFrame() {
        // This start the Frame of the PROJECT.
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        face = new javax.swing.JPanel();
        facedisplayer = new javax.swing.JPanel();
        facedetect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        facecount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        eyecount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dist1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dist2 = new javax.swing.JTextField();
        hcsrdetect = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        led1 = new javax.swing.JRadioButton();
        led2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        facedata = new javax.swing.JTextField();
        eyedata = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pitchSlider = new javax.swing.JSlider();
        pitch = new javax.swing.JLabel();
        rate = new javax.swing.JLabel();
        rateSlider = new javax.swing.JSlider();
        volume = new javax.swing.JLabel();
        volumeSlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        facedisplayer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout facedisplayerLayout = new javax.swing.GroupLayout(facedisplayer);
        facedisplayer.setLayout(facedisplayerLayout);
        facedisplayerLayout.setHorizontalGroup(
            facedisplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        facedisplayerLayout.setVerticalGroup(
            facedisplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        facedetect.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        facedetect.setText("ACTIVATE FACE/EYE DETECTION");
        facedetect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facedetectActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Number of detected Face:");

        facecount.setEditable(false);
        facecount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Number of detected Eye:");

        eyecount.setEditable(false);
        eyecount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Distance calculated by HCSR04-1 :");

        dist1.setEditable(false);
        dist1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Distance calculated by HCSR04-2 :");

        dist2.setEditable(false);
        dist2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        hcsrdetect.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcsrdetect.setText("ACTIVATE HEAD POSITION ESTIMATION");
        hcsrdetect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hcsrdetectActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Activated LED's:");

        led1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        led1.setForeground(new java.awt.Color(255, 0, 0));
        led1.setText("LED 1");

        led2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        led2.setForeground(new java.awt.Color(255, 0, 0));
        led2.setText("LED 2");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Real Time Face Data :  ");

        facedata.setEditable(false);
        facedata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        eyedata.setEditable(false);
        eyedata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Real Time Eye Data :  ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Audio Effect", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        pitchSlider.setMaximum(125);
        pitchSlider.setMinimum(50);
        pitchSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        pitchSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pitchSliderMouseReleased(evt);
            }
        });

        pitch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pitch.setText("Pitch");
        pitch.setToolTipText("It effects the pitch of chatBot");

        rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rate.setText("Rate");
        rate.setToolTipText("It affects the Speaking rate of the ChatBot.");

        rateSlider.setMaximum(150);
        rateSlider.setMinimum(100);
        rateSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        rateSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rateSliderMouseReleased(evt);
            }
        });

        volume.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        volume.setText("Volume");
        volume.setToolTipText("It affects the Volume of the ChatBot.");

        volumeSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        volumeSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                volumeSliderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pitchSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pitch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(volume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(pitchSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(pitch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout faceLayout = new javax.swing.GroupLayout(face);
        face.setLayout(faceLayout);
        faceLayout.setHorizontalGroup(
            faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(faceLayout.createSequentialGroup()
                        .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(faceLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(led1)
                                .addGap(18, 18, 18)
                                .addComponent(led2)))
                        .addContainerGap(998, Short.MAX_VALUE))
                    .addGroup(faceLayout.createSequentialGroup()
                        .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(eyedata, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(facedata, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(facedisplayer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(facedetect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, faceLayout.createSequentialGroup()
                                .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(facecount)
                                    .addComponent(eyecount))))
                        .addGap(49, 49, 49)
                        .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(faceLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dist2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, faceLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dist1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hcsrdetect, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        faceLayout.setVerticalGroup(
            faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faceLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(led1)
                    .addComponent(led2))
                .addGap(27, 27, 27)
                .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(faceLayout.createSequentialGroup()
                        .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(facedetect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hcsrdetect))
                        .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(faceLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dist1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dist2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(faceLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(facedisplayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(facecount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(faceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eyecount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(facedata, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eyedata, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(face, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(face, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facedetectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facedetectActionPerformed
        
        ChatBot bot = new ChatBot();
        bot.speakChatBot("Please Wait..Face Detection is activating!!", "kevin16", pitchSlider.getValue(),rateSlider.getValue(), volumeSlider.getValue()/100F);
        
        (new Thread(){
            @Override
            public void run(){
                /**
                 * Extend this VideoCapture to capture image from external camera
                 */
                VideoCapture capture = new VideoCapture(0);            
                MatOfRect rostros = new MatOfRect();
                MatOfByte mem = new MatOfByte();
                Mat frame = new Mat();
                Mat frame_gray = new Mat();
                Rect[] facesArray = null;   
                Rect[] eyearray = null;
                Graphics g;
                BufferedImage buff = null;
                while(capture.read(frame)){
                    if(frame.empty()){
                        System.out.println("No detection");
                        break;
                    }else{
                        try {
                            Mat crop = null;
                            g = facedisplayer.getGraphics();
                            Imgproc.cvtColor(frame, frame_gray, Imgproc.COLOR_BGR2GRAY);
                            Imgproc.equalizeHist(frame_gray, frame_gray);
                            double w = frame.width();
                            double h = frame.height();
                            faceDetector.detectMultiScale(frame_gray, rostros, 1.1, 2, 0|CASCADE_SCALE_IMAGE, new Size(30, 30), new Size(w, h) );
                            facesArray = rostros.toArray();
                            facedata.setText(null);
                            eyedata.setText(null);
                            for (int i = 0; i < facesArray.length; i++) {
                                facedata.setText(String.valueOf(facesArray[i]));
                                Point FaceCenter = new Point((facesArray[i].x + facesArray[i].width * 0.5),(facesArray[i].y + facesArray[i].height * 0.5));
                                Imgproc.ellipse(frame,FaceCenter,new Size(facesArray[i].width * 0.5, facesArray[i].height * 0.5),0,0,360,new Scalar(255, 0, 255), 4, 8, 0);
                                Mat faceROI = frame_gray.submat(facesArray[i]);
                                crop = faceROI.submat(4, (2*faceROI.width())/3, 0, faceROI.height());
                                eyeDetector.detectMultiScale(crop, rostros, 1.1, 5, 0,new Size(30,30), new Size());
                                eyearray = rostros.toArray();
                                eyedata.setText(null);
                                for(int j = 0 ; j < eyearray.length ; j++){
                                    eyedata.setText(String.valueOf(eyearray[j]));
                                    Point EyeCenter = new Point((facesArray[i].x + eyearray[j].x + eyearray[j].width * 0.5),(facesArray[i].y + eyearray[j].y + eyearray[j].height * 0.5));
                                    Imgproc.ellipse(frame,EyeCenter,new Size(eyearray[j].width * 0.5, eyearray[j].height * 0.5),0,0,360,new Scalar(150, 0, 255), 4, 8, 0);
                                    //Imgproc.line(frame, new Point(0,0),EyeCenter, new Scalar(0,0,255),WIDTH);
                                }
                                Imgproc.rectangle(frame,new Point(facesArray[i].x,facesArray[i].y),new Point(facesArray[i].x+facesArray[i].width,facesArray[i].y+facesArray[i].height),new Scalar(0, 0, 23, 220));
                                //Imgproc.line(frame, new Point(0,0),FaceCenter, new Scalar(0,0,0));
                                Imgproc.putText(frame, "Width: "+faceROI.width()+" Height: "+faceROI.height()+" X = "+facesArray[i].x+" Y = "+facesArray[i].y, new Point(facesArray[i].x, facesArray[i].y-20), 1, 1, new Scalar(255,255,255));
                            }
                            facecount.setText(String.valueOf(facesArray.length));
                            if(facesArray.length != 0){
                                eyecount.setText(String.valueOf(eyearray.length));
                            }
                            Imgcodecs.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            buff = (BufferedImage) im;
                            g.drawImage(buff, 0, 0, facedisplayer.getWidth(), facedisplayer.getHeight() , 0, 0, buff.getWidth(), buff.getHeight(), null);
                            
                            //Setting ON on led1
                            //Glow the led of arduino uno.
                            led1.setSelected(true);
                    
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }      
                }
            }
        }).start();
    }//GEN-LAST:event_facedetectActionPerformed

    private void hcsrdetectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hcsrdetectActionPerformed
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            led2.setSelected(false);
            JOptionPane.showMessageDialog(this,"PORT IS NOT ACTIVE!!","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(),TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
        }
    }//GEN-LAST:event_hcsrdetectActionPerformed

    private void pitchSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pitchSliderMouseReleased
        pitch.setText("Pitch: "+pitchSlider.getValue());
    }//GEN-LAST:event_pitchSliderMouseReleased

    private void rateSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rateSliderMouseReleased
        rate.setText("Rate: "+rateSlider.getValue());
    }//GEN-LAST:event_rateSliderMouseReleased

    private void volumeSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeSliderMouseReleased
        volume.setText("Volume: "+volumeSlider.getValue());
    }//GEN-LAST:event_volumeSliderMouseReleased

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }
    
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();
                led2.setSelected(true);
                if(switcher){
                    dist1.setText(String.valueOf(inputLine));
                    switcher = false;
                }else{
                    dist2.setText(String.valueOf(inputLine));
                    switcher = true;                    
                }
            } catch (IOException e) {
                    System.err.println(e.toString());
            }
        }
    }
    
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDataCollectorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainDataCollectorFrame().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dist1;
    private javax.swing.JTextField dist2;
    private javax.swing.JTextField eyecount;
    private javax.swing.JTextField eyedata;
    private javax.swing.JPanel face;
    private javax.swing.JTextField facecount;
    private javax.swing.JTextField facedata;
    private javax.swing.JButton facedetect;
    private javax.swing.JPanel facedisplayer;
    private javax.swing.JButton hcsrdetect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton led1;
    private javax.swing.JRadioButton led2;
    private javax.swing.JLabel pitch;
    private javax.swing.JSlider pitchSlider;
    private javax.swing.JLabel rate;
    private javax.swing.JSlider rateSlider;
    private javax.swing.JLabel volume;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}