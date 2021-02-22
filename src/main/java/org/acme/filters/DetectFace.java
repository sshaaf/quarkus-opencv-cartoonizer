package org.acme.filters;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class DetectFace implements Filter{

    private String haarcascadeFilePath = null;

    public DetectFace(String haarCascadeFilePath){
        this.haarcascadeFilePath = haarCascadeFilePath;
    }

    @Override
    public Mat process(Mat src) {
       // Mat img_gray = new BGR2Gray().process(src);
        MatOfRect faces = new MatOfRect();
        CascadeClassifier cc = new CascadeClassifier(haarcascadeFilePath);
        cc.detectMultiScale(src,faces, 1.1f,5,2  , new Size(30,30));

        System.out.println(String.format("Detected %s faces",
                faces.toArray().length));

        // Drawing boxes
        for (Rect rect : faces.toArray()) {
            Imgproc.rectangle(
                    src,
                    new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 0, 255),
                    3
            );
        }

        return src;
    }
}
