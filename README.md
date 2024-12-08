# DSA Preparation Kit

## Sorting Algorithm
 

#### Bubble Sort

```java
boolean swap;
for(int i=0;i<n;i++)
{
    swap = false;
    for(int j=1;j<n-i;j++)
    {
        if(nums[j-1]>nums[j])
        {
            swap(nums,j-1,j);
            swap = true;
        }
        }
        if(swap == false)
        {
            break;
        }
    }
```