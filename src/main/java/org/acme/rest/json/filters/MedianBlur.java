package org.acme.rest.json.filters;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class MedianBlur implements Filter{

    @Override
    public String filterName() {
        return null;
    }

    @Override
    public Mat process(Mat src) {
        int MAX_KERNEL_LENGTH = 31;
        int kernel_size = 3 + 2*( 3 );
        Mat dst = new Mat();
        for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
            Imgproc.medianBlur(src, dst, kernel_size);
        }
        return dst;
    }
}