# Use a more recent Node.js version
FROM node:latest

# Set the working directory in the container
WORKDIR /app

# Copy the package.json and package-lock.json files to the container
COPY package*.json ./

# Install the dependencies
RUN npm install

# Copy the rest of the application code to the container
COPY . .

# Build the Vite app
RUN npm run build

# Expose the port Vite uses
EXPOSE 5173

# Serve the built application
CMD ["npm", "run","dev"]
