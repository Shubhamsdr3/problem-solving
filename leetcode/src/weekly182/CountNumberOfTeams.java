package weekly182;

public class CountNumberOfTeams {

    private static int numTeams(int[] rating) {
        int teamCount = 0;
        int[] newArray = new int[rating.length];
        System.arraycopy(rating, 0, newArray, 0, rating.length);
        int i=0;
        int rate = -1;
        while (i < newArray.length) {
            for (int j = i+1; j < newArray.length; j++) {
                if (newArray[i] > newArray[j] || newArray[i] < newArray[j]) {
                    newArray[i] = rate;
                    newArray[j] = rate;
                    teamCount++;
                }
            }
            boolean allElementsCovered = true;
            for (int k = i+1; k < newArray.length; k++) {
                if (newArray[i] != -1) {
                    allElementsCovered = false;
                    break;
                }
            }
            if (allElementsCovered) {
                i++;
            }
        }
        return teamCount;
    }

    private static int numTeams1(int[] a) {
        int n = a.length;
        int ct = 0;
        for(int i= 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                for(int k = j+1;k < n;k++){
                    if(a[i] < a[j] && a[j] < a[k]){
                        ct++;
                    }
                    if(a[i] > a[j] && a[j] > a[k]) {
                        ct++;
                    }
                }
            }
        }
        return ct;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,4,1};
        System.out.println(numTeams1(arr));
    }
}
