package org.acme.filters;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class BGR2Gray implements Filter{

    @Override
    public Mat process(Mat src) {

        Mat dst = src;
        Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);

        return dst;
    }
}
