public class Ville {
    static double[][] matriceDist =
            {
                    {0.0, 717.0, 667.0, 1015.0, 673.0, 686.0, 449.0, 344.0, 417.0, 604.0, 665.0, 291.0, 408.0, 517.0, 504.0, 668.0, 973.0, 901.0},
                    {717.0, 0.0, 52.0, 364.0, 42.0, 22.0, 599.0, 727.0, 813.0, 610.0, 597.0, 426.0, 458.0, 634.0, 435.0, 70.0, 526.0, 236.0},
                    {667.0, 52.0, 0.0, 340.0, 7.0, 20.0, 558.0, 686.0, 772.0, 569.0, 556.0, 376.0, 409.0, 593.0, 394.0, 29.0, 502.0, 239.0},
                    {1015.0, 364.0, 340.0, 0.0, 332.0, 336.0, 572.0, 700.0, 787.0, 583.0, 555.0, 725.0, 615.0, 607.0, 487.0, 340.0, 176.0, 391.0},
                    {673.0, 42.0, 7.0, 332.0, 0.0, 14.0, 563.0, 691.0, 777.0, 574.0, 561.0, 385.0, 417.0, 598.0, 399.0, 35.0, 494.0, 232.0},
                    {686.0, 22.0, 20.0, 336.0, 14.0, 0.0, 574.0, 702.0, 788.0, 585.0, 572.0, 396.0, 428.0, 609.0, 410.0, 46.0, 507.0, 224.0},
                    {449.0, 599.0, 558.0, 572.0, 563.0, 574.0, 0.0, 130.0, 217.0, 154.0, 216.0, 506.0, 264.0, 68.0, 205.0, 531.0, 592.0, 793.0},
                    {344.0, 727.0, 686.0, 700.0, 691.0, 702.0, 130.0, 0.0, 95.0, 286.0, 347.0, 634.0, 392.0, 199.0, 333.0, 659.0, 720.0, 921.0},
                    {417.0, 813.0, 772.0, 787.0, 777.0, 788.0, 217.0, 95.0, 0.0, 372.0, 434.0, 692.0, 479.0, 286.0, 419.0, 746.0, 807.0, 1007.0},
                    {604.0, 610.0, 569.0, 583.0, 574.0, 585.0, 154.0, 286.0, 372.0, 0.0, 62.0, 516.0, 273.0, 102.0, 197.0, 542.0, 479.0, 804.0},
                    {665.0, 597.0, 556.0, 555.0, 561.0, 572.0, 216.0, 347.0, 434.0, 62.0, 0.0, 558.0, 316.0, 161.0, 240.0, 530.0, 432.0, 775.0},
                    {291.0, 426.0, 376.0, 725.0, 385.0, 396.0, 506.0, 634.0, 692.0, 516.0, 558.0, 0.0, 259.0, 540.0, 289.0, 381.0, 731.0, 613.0},
                    {408.0, 458.0, 409.0, 615.0, 417.0, 428.0, 264.0, 392.0, 479.0, 273.0, 316.0, 259.0, 0.0, 296.0, 111.0, 410.0, 635.0, 642.0},
                    {517.0, 634.0, 593.0, 607.0, 598.0, 609.0, 68.0, 199.0, 286.0, 102.0, 161.0, 540.0, 296.0, 0.0, 219.0, 564.0, 597.0, 826.0},
                    {504.0, 435.0, 394.0, 487.0, 399.0, 410.0, 205.0, 333.0, 419.0, 197.0, 240.0, 289.0, 111.0, 219.0, 0.0, 370.0, 505.0, 622.0},
                    {668.0, 70.0, 29.0, 340.0, 35.0, 46.0, 531.0, 659.0, 746.0, 542.0, 530.0, 381.0, 410.0, 564.0, 370.0, 0.0, 503.0, 255.0},
                    {973.0, 526.0, 502.0, 176.0, 494.0, 507.0, 592.0, 720.0, 807.0, 479.0, 432.0, 731.0, 635.0, 597.0, 505.0, 503.0, 0.0, 553.0},
                    {901.0, 236.0, 239.0, 391.0, 232.0, 224.0, 793.0, 921.0, 1007.0, 804.0, 775.0, 613.0, 642.0, 826.0, 622.0, 255.0, 553.0, 0.0}
            };

    private int index;
    private int classement;
    private String name;

    public Ville(String name, int classement) {
        this.name = name;
        this.classement = classement;
        this.index = classement - 1 ;
    }

    public int getClassement() {
        return classement;
    }

    public String getName() {
        return name;
    }

    public double getDist(Ville v) {
        return matriceDist[index][v.index];
    }
}
