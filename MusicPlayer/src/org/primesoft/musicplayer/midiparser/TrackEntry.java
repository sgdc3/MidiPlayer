/*
 * MusicPlayer a plugin that allows you to play custom music.
 * Copyright (c) 2014, SBPrime <https://github.com/SBPrime/>
 * Copyright (c) MusicPlayer contributors
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted free of charge provided that the following 
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution,
 * 3. Redistributions of source code, with or without modification, in any form 
 *    other then free of charge is not allowed,
 * 4. Redistributions in binary form in any form other then free of charge is 
 *    not allowed.
 * 5. Any derived work based on or containing parts of this software must reproduce 
 *    the above copyright notice, this list of conditions and the following 
 *    disclaimer in the documentation and/or other materials provided with the 
 *    derived work.
 * 6. The original author of the software is allowed to change the license 
 *    terms or the entire license of the software as he sees fit.
 * 7. The original author of the software is allowed to sublicense the software 
 *    or its parts using any license terms he sees fit.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.primesoft.musicplayer.midiparser;

import java.util.Comparator;
import org.bukkit.Instrument;
import org.bukkit.Note.Tone;

/**
 *
 * @author SBPrime
 */
public class TrackEntry implements Comparable<TrackEntry> {
    private long m_milis;
    private final Instrument m_instrument;
    private int m_octave;
    private final Tone m_note;
    private final boolean m_sharp;    

    public long getMilis() {
        return m_milis;
    }
    
    public void setMilis(long milis) {
        m_milis = milis;
    }

    public Instrument getInstrument() {
        return m_instrument;
    }

    public int getOctave() {
        return m_octave;
    }
    
    public void setOctave(int octave) {
        m_octave = octave;
    }

    public Tone getNote() {
        return m_note;
    }

    public boolean isSharp() {
        return m_sharp;
    }

    public TrackEntry(long milis, Instrument instrument, int octave, int note) {
        final Tone[] notes = {Tone.C, Tone.C, Tone.D, Tone.D, Tone.E, Tone.F, Tone.F, Tone.G, Tone.G, Tone.A, Tone.A, Tone.B};
        final boolean[] sharp = {false, true, false, true, false, false, true, false, true, false, true, false};

        m_milis = milis;
        m_instrument = instrument;
        m_octave = octave;

        m_note = notes[note];
        m_sharp = sharp[note];
    }

    @Override
    public int compareTo(TrackEntry o) {
        if (o == null) {
            return 1;
        }
        
        long diff = m_milis - o.m_milis;
        
        if (diff == 0) {
            return 0;
        }
        
        if (diff < 0) {
            return -1;
        }
        
        return 1;
    }
}