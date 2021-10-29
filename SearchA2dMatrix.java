class SearchA2dMatrix{
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int low = 0;
            int high = rows*cols-1;
            while(low<=high){
                int mid = low+(high-low)/2;
                int mid_point = matrix[mid/cols][mid%cols];
                if(mid_point==target){
                    return true;
                }else if(mid_point>target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            return false;
            
            
        }
    }