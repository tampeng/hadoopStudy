package com.mr.reduceSizeJoin;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CombineValues implements WritableComparable<CombineValues>{
    private Text joinKey;//链接关键字
    private Text flag;//文件来源标志
    private Text secondPart;//除了链接键外的其他部分

    public CombineValues() {
        this.joinKey = joinKey;
        this.flag = flag;
        this.secondPart = secondPart;
    }

    public Text getJoinKey() {
        return joinKey;
    }

    public void setJoinKey(Text joinKey) {
        this.joinKey = joinKey;
    }

    public Text getFlag() {
        return flag;
    }

    public void setFlag(Text flag) {
        this.flag = flag;
    }

    public Text getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(Text secondPart) {
        this.secondPart = secondPart;
    }

    @Override
    public int compareTo(CombineValues o) {
        return this.joinKey.compareTo(o.getJoinKey());
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.joinKey.write(dataOutput);
        this.flag.write(dataOutput);
        this.secondPart.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.joinKey.readFields(dataInput);
        this.flag.readFields(dataInput);
        this.secondPart.readFields(dataInput);
    }

    @Override
    public String toString() {
        return "[flag="+this.flag.toString()+",joinKey="+this.joinKey.toString()+",secondPart="+this.secondPart.toString()+"]";
    }
}

