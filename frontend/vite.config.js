import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vitejs.dev/config/
export default defineConfig({
  esbuild: {
    // Enable syntax transformations if needed
    target: 'esnext',
  },
  server: {
    port:3000
  },
  plugins: [react()],
})
