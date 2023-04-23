// 클래스를 배열처럼 쓰기

/*
* 클래스 개념 다시 익힐 겸 코드 다시 보기
* */
class PhysicalExamination {
    static final int VMAX = 21;

    static class PhyscData {
        String name;
        int height;
        double vision;

        // 생성자를 이용하여 입력된 값 넣기
        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        // PhyscData 인스턴스 배열에 있는 height 값을 이용하여 키 평균값 내기
        static double aveHeight(PhyscData[] dat) {
            double sum = 0;

            for (int i = 0; i < dat.length; i++)
                sum += dat[i].height;

            return sum / dat.length
        }

        // PhyscData 인스턴스 배열에 있는 vision 값을 이용하여 시력 분포 내기
        static void distVision(PhyscData[] dat, int[] dist) {
            int i = 0;
            dist[i] = 0;

            for (i = 0; i < dat.length; i++)
                if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
                    dist[(int) (dat[i].vision * 10)]++;
        }
    }
}